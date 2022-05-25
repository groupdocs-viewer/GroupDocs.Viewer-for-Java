package com.groupdocs.ui.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.groupdocs.ui.cache.model.*;
import com.groupdocs.ui.exception.DiskAccessException;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.*;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileViewerCache implements ViewerCache {
    private static final Object mSync = new Object();
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final long WAIT_TIMEOUT = 100L;

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

        String filePath = this.getCacheFilePath(key);
        try {
            OutputStream dst = null;
            try {
                if (value instanceof InputStream) {
                    dst = this.getStream(filePath);
                    IOUtils.copy((InputStream) value, dst);

                } else {
                    dst = this.getStream(filePath);
                    MAPPER.writerWithDefaultPrettyPrinter().writeValue(dst, value);
                }
            } finally {
                if (dst != null) {
                    dst.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deserializes data associated with this key if present.
     *
     * @param key A key identifying the requested entry.
     * @return true if the key was found.
     */
    public <T> T getValue(String key, T defaultEntry, Class<?>[] clazzs) {
        String cacheFilePath = this.getCacheFilePath(key);
        if (!new File(cacheFilePath).exists()) {
            set(key, defaultEntry);
            return defaultEntry;
        }
        try (final FileInputStream inputStream = new FileInputStream(cacheFilePath)) {
            // Avoid using byte array in case of having big objects
            final byte[] bytes = IOUtils.toByteArray(inputStream);

            for (Class<?> clazz : clazzs) {
                try {
                    return (T) MAPPER.readValue(bytes, clazz);
                } catch (JsonMappingException e) {
                    // continue;
                }
            }
            final InputStream fileInputStream = new ByteArrayInputStream(bytes);
            try {
                return (T) fileInputStream;
            } catch (Exception e) {
                fileInputStream.close();
                throw new TotalGroupDocsException("Cache file '" + cacheFilePath + "' was not deserialized correctly!", e);
            }
        } catch (IOException e) {
            throw new TotalGroupDocsException("Cache loading error - IO exception", e);
        }
    }


    @Override
    public String getCacheFilePath(String key) {
        Path keyCachePath = getCachePath();

        try {
            if (Files.notExists(keyCachePath)) {
                synchronized (mSync) {
                    if (Files.notExists(keyCachePath)) {
                        Files.createDirectories(keyCachePath);
                    }
                }
            }
        } catch (Exception e) {
            throw new DiskAccessException("create cache directory", keyCachePath);
        }
        Path filePath = keyCachePath.resolve(key);

        return filePath.toString();
    }

    @Override
    public boolean doesNotContains(String key) {
        Path file = getCachePath().resolve(key);
        synchronized (mSync) {
            return Files.notExists(file);
        }
    }

    private OutputStream getStream(String path) throws FileNotFoundException, InterruptedException {
        OutputStream stream = null;
        long totalTime = 0;
        long interval = 50;
        while (stream == null) {
            try {
                stream = new FileOutputStream(path);
            } catch (IOException e) {
                Thread.sleep(50);
                totalTime += interval;

                if (totalTime > WAIT_TIMEOUT) {
                    throw e;
                }
            }
        }

        return stream;
    }

    @Override
    public Path getCachePath() {
        return mCachePath;
    }
}
