package com.groupdocs.ui.viewer.dropwizard.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.groupdocs.ui.viewer.dropwizard.cache.model.*;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FileViewerCache implements ViewerCache {
    private static final long REQUEST_SYNC_LOCK_TIMEOUT = 500L;
    private static final int REQUEST_SYNC_LOCK_TRIES = 60; // * REQUEST_SYNC_LOCK_TIMEOUT = lock timeout
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(FileViewerCache.class);
    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Lock readLock = readWriteLock.readLock();
    private static final Lock writeLock = readWriteLock.writeLock();

    static {
        MAPPER.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        SimpleModule module = new SimpleModule(Version.unknownVersion());

        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
        resolver.addMapping(ArchiveViewInfo.class, ArchiveViewInfoModel.class);
        resolver.addMapping(Attachment.class, AttachmentModel.class);
        resolver.addMapping(CadViewInfo.class, CadViewInfoModel.class);
        resolver.addMapping(Character.class, CharacterModel.class);
        resolver.addMapping(FileInfo.class, FileInfoModel.class);
        resolver.addMapping(Layer.class, LayerModel.class);
        resolver.addMapping(Layout.class, LayoutModel.class);
        resolver.addMapping(Line.class, LineModel.class);
        resolver.addMapping(LotusNotesViewInfo.class, LotusNotesViewInfoModel.class);
        resolver.addMapping(OutlookViewInfo.class, OutlookViewInfoModel.class);
        resolver.addMapping(Page.class, PageModel.class);
        resolver.addMapping(PdfViewInfo.class, PdfViewInfoModel.class);
        resolver.addMapping(ProjectManagementViewInfo.class, ProjectManagementViewInfoModel.class);
        resolver.addMapping(ViewInfo.class, ViewInfoModel.class);
        resolver.addMapping(Word.class, WordModel.class);

        module.setAbstractTypes(resolver);

        MAPPER.registerModule(module);
    }

    /**
     * Gets the Relative or absolute path to the cache folder.
     */
    public Path mCachePath;

    /**
     * Initializes a new instance of the FileViewerCache class.
     *
     * @param cachePath or absolute path where document cache will be stored.
     */
    public FileViewerCache(Path cachePath) {
        if (cachePath == null) {
            throw new IllegalArgumentException("cachePath");
        }

        this.mCachePath = cachePath;

        // Setting factory before using custom models for caching
        // You still can use embedded implementation of models (*Impl) if you don't need
        // any specific annotations for serialization. In this way no need to set the factory
        // Embedded models are just implements Serializable interface
        CacheableFactory.setInstance(new FileViewerCacheableFactory());
    }

    /**
     * Serializes data to the local disk.
     *
     * @param key   An unique identifier for the cache entry.
     * @param value The object to serialize.
     */
    @Override
    public void set(String key, Object value) {
        if (value == null) {
            return;
        }

        Path cacheFilePath = this.getCacheFilePath(key);

        if (cacheFilePath == null) {
            return; // Problems with creating cache directory. Cache is not working for the key
        }

        int tryNumber = REQUEST_SYNC_LOCK_TRIES;
        while ((tryNumber--) > 0 && Files.notExists(cacheFilePath)) {
            try {
                final boolean tryLock = writeLock.tryLock(REQUEST_SYNC_LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    logger.trace("cache.set -> writeLock locked (cacheFilePath is '{}')", cacheFilePath);
                    try {
                        if (Files.notExists(cacheFilePath)) {
                            writeValueToStream(value, cacheFilePath);
                            break;
                        }
                    } finally {
                        writeLock.unlock();
                        logger.trace("cache.set -> writeLock unlocked (cacheFilePath is '{}')", cacheFilePath);
                    }
                } else {
                    logger.trace("cache.set -> {} try to acquire write lock was NOT successful", REQUEST_SYNC_LOCK_TRIES - tryNumber);
                }
            } catch (InterruptedException e) {
                logger.warn("Thread that worked with cache and waited for write lock was interrupted", e);
            } catch (Exception e) {
                logger.warn("Exception throws while writing object to cache by cacheFilePath '" + cacheFilePath + "'", e);
//            throw new ReadWriteException(e);
            }
        }
        if (tryNumber <= 0) {
            logger.warn("Value with cacheFilePath '{}' was not saved into cache because write lock was not acquired during {}ms", cacheFilePath, REQUEST_SYNC_LOCK_TIMEOUT * REQUEST_SYNC_LOCK_TRIES);
        }
    }

    private static void writeValueToStream(Object value, Path cacheFilePath) throws IOException {
        if (value instanceof InputStream) {
            try (OutputStream dst = new BufferedOutputStream(Files.newOutputStream(cacheFilePath))) {
                IOUtils.copy((InputStream) value, dst);
            }
        } else {
            try (OutputStream dst = new BufferedOutputStream(Files.newOutputStream(cacheFilePath))) {
                MAPPER.writerWithDefaultPrettyPrinter().writeValue(dst, value);
            }
        }
    }

    /**
     * Deserializes data associated with this key if present.
     *
     * @param key A key identifying the requested entry.
     * @return true if the key was found.
     */
    public <T> T get(String key, DefaultValue<T> defaultEntry, Class<?>[] clazzs) {
        Path cacheFilePath = this.getCacheFilePath(key);

        if (cacheFilePath == null) {
            logger.trace("cacheFilePath is null, continuing without caching");
            return defaultEntry.create(); // Problems with creating cache directory. Cache is not working for the key
        }

        int tryNumber = REQUEST_SYNC_LOCK_TRIES;
        while ((tryNumber--) > 0 && Files.notExists(cacheFilePath)) {
            try {
                final boolean tryLock = writeLock.tryLock(REQUEST_SYNC_LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    logger.trace("cache.set -> writeLock locked (cacheFilePath is '{}')", cacheFilePath);
                    try {
                        if (Files.notExists(cacheFilePath)) {

                            T defaultValue = defaultEntry.create();

                            writeValueToStream(defaultValue, cacheFilePath);
                            return defaultValue;
                        } else {
                            break;
                        }
                    } finally {
                        writeLock.unlock();
                        logger.trace("cache.set -> writeLock unlocked (cacheFilePath is '{}')", cacheFilePath);
                    }
                } else {
                    logger.trace("cache.set -> {} try to acquire write lock was NOT successful", REQUEST_SYNC_LOCK_TRIES - tryNumber);
                }
            } catch (InterruptedException e) {
                logger.warn("Thread that worked with cache and waited for write lock was interrupted", e);
            } catch (Exception e) {
                logger.warn("Exception throws while writing object to cache by cacheFilePath '" + cacheFilePath + "'", e);
//            throw new ReadWriteException(e);
            }
        }
        if (tryNumber <= 0) {
            logger.warn("Value with cacheFilePath '{}' was not saved into cache because write lock was not acquired during {}ms", cacheFilePath, REQUEST_SYNC_LOCK_TIMEOUT * REQUEST_SYNC_LOCK_TRIES);
        }

        try {
            if (Files.exists(cacheFilePath)) {
                final boolean tryLock = readLock.tryLock(REQUEST_SYNC_LOCK_TIMEOUT * REQUEST_SYNC_LOCK_TRIES, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    logger.trace("cache.get -> readLock locked (cacheFilePath is '{}')", cacheFilePath);
                    try {
                        if (Files.exists(cacheFilePath)) {
                            for (Class<?> clazz : clazzs) {
                                try (final BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(cacheFilePath))) {
                                    return (T) MAPPER.readValue(inputStream, clazz);
                                } catch (JsonMappingException e) {
                                    // continue;
                                } catch (Exception e) {
                                    logger.warn("Exception throws while reading cache file '" + cacheFilePath + "' with cacheFilePath '" + cacheFilePath + "'", e);
                                }
                            }
                            try {
                                // Was not deserialized, probably it must be raw data
                                return (T) new BufferedInputStream(Files.newInputStream(cacheFilePath));
                            } catch (IOException e) {
                                logger.warn("Exception throws while reading cache file '" + cacheFilePath + "' with cacheFilePath '" + cacheFilePath + "' as raw data", e);
                            }
                        }
                    } finally {
                        readLock.unlock();
                        logger.trace("cache.get -> readLock unlocked (cacheFilePath is '{}')", cacheFilePath);
                    }
                } else {
                    logger.warn("Value with cacheFilePath '{}' was not got from cache because read lock was not acquired during {}ms. Default entry was used.", cacheFilePath, REQUEST_SYNC_LOCK_TIMEOUT * REQUEST_SYNC_LOCK_TRIES);
                    return defaultEntry.create();
                }
            }
        } catch (InterruptedException e) {
            logger.warn("Thread that worked with cache and waited for read lock was interrupted", e);
        }
        return null;
    }

    @Override
    public Path getCacheFilePath(String key) {
        Path keyCachePath = getCachePath();

        int tryNumber = REQUEST_SYNC_LOCK_TRIES;
        while ((tryNumber--) > 0 && Files.notExists(keyCachePath)) {
            try {
                final boolean tryLock = writeLock.tryLock(REQUEST_SYNC_LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    logger.trace("cache.getCacheFilePath -> writeLock locked (keyCachePath is '{}')", keyCachePath);
                    try {
                        if (Files.notExists(keyCachePath)) {
                            Files.createDirectories(keyCachePath);
                        }
                        break;
                    } finally {
                        writeLock.unlock();
                        logger.trace("cache.getCacheFilePath -> writeLock unlocked (keyCachePath is '{}')", keyCachePath);
                    }
                } else {
                    logger.trace("cache.getCacheFilePath -> {} try to acquire write lock was NOT successful", REQUEST_SYNC_LOCK_TRIES - tryNumber);
                }
            } catch (InterruptedException e) {
                logger.error("Thread that worked with cache directory and waited for write lock was interrupted", e);
                return null;
            } catch (IOException e) {
                logger.error("Cache directory with keyCachePath '" + keyCachePath + "' was not created", e);
                return null;
            }
        }
        if (tryNumber <= 0) {
            logger.warn("Cache directory ('{}') was not created because write lock was not acquired during {}ms", keyCachePath, REQUEST_SYNC_LOCK_TIMEOUT * REQUEST_SYNC_LOCK_TRIES);
        }
        return keyCachePath.resolve(key);
    }

    @Override
    public boolean doesNotContains(String key) {
        Path cacheFilePath = getCachePath().resolve(key);

        return Files.notExists(cacheFilePath);
    }

    @Override
    public Path getCachePath() {
        return mCachePath;
    }
}
