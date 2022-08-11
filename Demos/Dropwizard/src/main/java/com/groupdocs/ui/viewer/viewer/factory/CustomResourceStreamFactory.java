package com.groupdocs.ui.viewer.viewer.factory;

import com.groupdocs.ui.viewer.cache.ViewerCache;
import com.groupdocs.ui.viewer.exception.ReadWriteException;
import com.groupdocs.viewer.interfaces.ResourceStreamFactory;
import com.groupdocs.viewer.results.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomResourceStreamFactory implements ResourceStreamFactory {
    private static final Logger logger = LoggerFactory.getLogger(CustomResourceStreamFactory.class);
    private final ViewerCache cache;
    private final Path tempDirectory;
    private final String urlPrefix;

    public CustomResourceStreamFactory(ViewerCache cache, String sourceFileName) {
        this.cache = cache;
        this.urlPrefix = "/viewer/resources/" + sourceFileName.replace(".", "_");

        try {
            this.tempDirectory = Files.createTempDirectory("gd_sp_rsf_");
        } catch (IOException e) {
            logger.warn("Can't create temp directory. Can't create ResourceStreamFactory object.", e);
            throw new ReadWriteException(e);
        }
    }

    @Override
    public OutputStream createResourceStream(int pageNumber, Resource resource) {
        final String cacheKey = createCacheKey(pageNumber, resource);
        final Path resourcePath = tempDirectory.resolve(cacheKey);

        try {
            return new FileOutputStream(resourcePath.toFile());
        } catch (FileNotFoundException e) {
            logger.warn("Can't create temp file '" + resourcePath + "'. Can't create resource stream.", e);
            throw new ReadWriteException(e);
        }
    }

    @Override
    public String createResourceUrl(int pageNumber, Resource resource) {
        final String cacheKey = createCacheKey(pageNumber, resource);
        return urlPrefix + "/" + cacheKey;
    }

    @Override
    public void closeResourceStream(int pageNumber, Resource resource, OutputStream outputStream) {
        final String cacheKey = createCacheKey(pageNumber, resource);
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
            logger.warn("Can't close resource stream or move data to cache.", e);
        } finally {
            try {
                if (!Files.deleteIfExists(resourcePath)) {
                    Files.delete(resourcePath);
                }
            } catch (IOException e) {
                logger.warn("Can't delete temp resource stream files.", e);
            }
        }
    }

    private String createCacheKey(int pageNumber, Resource resource) {
        return "p" + pageNumber + "_" + resource.getFileName();
    }
}
