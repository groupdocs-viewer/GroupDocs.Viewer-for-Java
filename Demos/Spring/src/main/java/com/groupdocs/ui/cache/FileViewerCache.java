package com.groupdocs.ui.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.groupdocs.ui.cache.mixin.*;
import com.groupdocs.ui.exception.DiskAccessException;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.viewer.results.*;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.utils.PathUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileViewerCache implements ViewerCache {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final long WAIT_TIMEOUT = 100L;

    static {
        MAPPER.addMixIn(CadViewInfo.class, CadViewInfoMixIn.class);
        MAPPER.addMixIn(Character.class, CharacterMixIn.class);
        MAPPER.addMixIn(Layer.class, LayerMixIn.class);
        MAPPER.addMixIn(Layout.class, LayoutMixIn.class);
        MAPPER.addMixIn(Line.class, LineMixIn.class);
        MAPPER.addMixIn(OutlookViewInfo.class, OutlookViewInfoMixIn.class);
        MAPPER.addMixIn(Page.class, PageMixIn.class);
        MAPPER.addMixIn(PdfViewInfo.class, PdfViewInfoMixIn.class);
        MAPPER.addMixIn(ProjectManagementViewInfo.class, ProjectManagementViewInfoMixIn.class);
        MAPPER.addMixIn(ViewInfo.class, ViewInfoMixIn.class);
        MAPPER.addMixIn(Word.class, WordMixIn.class);
    }

    /**
     * Gets the Relative or absolute path to the cache folder.
     */
    public String mCachePath;
    /**
     * Gets the sub-folder to append to the CachePath.
     */
    public String mCacheSubFolder;

    /**
     * Initializes a new instance of the FileViewerCache class.
     *
     * @param cachePath      or absolute path where document cache will be stored.
     * @param cacheSubFolder sub-folder to append to cachePath.
     */
    public FileViewerCache(String cachePath, String cacheSubFolder) {
        if (cachePath == null) {
            throw new IllegalArgumentException("cachePath");
        }

        if (cacheSubFolder == null) {
            throw new IllegalArgumentException("cacheSubFolder");
        }

        this.mCachePath = cachePath;
        this.mCacheSubFolder = cacheSubFolder;
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
        try {
            for (Class<?> clazz : clazzs) {
                final FileInputStream inputStream = new FileInputStream(cacheFilePath);
                try {
                    return (T)  MAPPER.readValue(inputStream, clazz);
                } catch (UnrecognizedPropertyException | InvalidDefinitionException e) {
                    // continue;
                } finally {
                    inputStream.close();
                }
            }
        } catch (MismatchedInputException e) {
            try {
                return (T) new FileInputStream(cacheFilePath);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException e) {
            throw new TotalGroupDocsException("Cache loading error", e);
        }
        return null;
    }


    @Override
    public String getCacheFilePath(String key) {
        String folderPath = PathUtils.combine(this.getCachePath(), this.getCacheSubFolder());
        String filePath = PathUtils.combine(folderPath, key);

        final File file = new File(folderPath);
        if (!file.exists() && !file.mkdirs()) {
            throw new DiskAccessException("create cache directory", file);
        }

        return filePath;
    }

    @Override
    public boolean doesNotContains(String key) {
        String file = PathUtils.combine(this.getCachePath(), this.getCacheSubFolder(), key);
        return !new File(file).exists();
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
    public String getCachePath() {
        return mCachePath;
    }

    @Override
    public String getCacheSubFolder() {
        return mCacheSubFolder;
    }
}
