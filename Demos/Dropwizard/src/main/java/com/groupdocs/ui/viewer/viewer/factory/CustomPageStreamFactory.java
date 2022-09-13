package com.groupdocs.ui.viewer.viewer.factory;

import com.groupdocs.ui.viewer.cache.ViewerCache;
import com.groupdocs.ui.viewer.exception.ReadWriteException;
import com.groupdocs.viewer.interfaces.PageStreamFactory;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomPageStreamFactory implements PageStreamFactory, Closeable {
    private static final Logger logger = LoggerFactory.getLogger(CustomPageStreamFactory.class);
    private final String extension;
    private final Path tempDirectory;
    private final ViewerCache cache;

    public CustomPageStreamFactory(ViewerCache cache, String extension) {
        this.cache = cache;
        this.extension = extension;

        try {
            this.tempDirectory = Files.createTempDirectory("gd_sp_psf_");
        } catch (IOException e) {
            logger.warn("Can't create temp directory. Can't create PageStreamFactory object.", e);
            throw new ReadWriteException(e);
        }
    }

    @Override
    public OutputStream createPageStream(int pageNumber) {
        String cacheKey = createCacheKey(pageNumber);
        final Path resourcePath = tempDirectory.resolve(cacheKey);

        try {
            return new FileOutputStream(resourcePath.toFile());
        } catch (FileNotFoundException e) {
            logger.warn("Can't create temp file '" + resourcePath + "'. Can't create page stream.", e);
            throw new ReadWriteException(e);
        }
    }

    @Override
    public void closePageStream(int pageNumber, OutputStream outputStream) {
        final String cacheKey = createCacheKey(pageNumber);
        final Path resourcePath = tempDirectory.resolve(cacheKey);

        try {
            try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(resourcePath))) {
                this.cache.set(cacheKey, inputStream);
            } catch (IOException e) {
                logger.warn("Can't copy temp file '" + resourcePath + "' to cache.", e);
                throw new RuntimeException(e);
            }

            outputStream.close();
        } catch (IOException e) {
            logger.warn("Can't close page stream or move data to cache.", e);
        }
    }

    private String createCacheKey(int pageNumber) {
        return "p" + pageNumber + extension;
    }

    @Override
    public void close() throws IOException {
        try {
            FileUtils.deleteDirectory(this.tempDirectory.toFile());
        } catch (IOException e) {
            logger.warn("Can't delete temp directory: " + this.tempDirectory, e);
        }
    }
}
