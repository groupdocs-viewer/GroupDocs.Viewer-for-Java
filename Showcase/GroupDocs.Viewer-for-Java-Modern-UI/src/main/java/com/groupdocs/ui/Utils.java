package com.groupdocs.ui;

import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.domain.image.PageImage;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;
import com.groupdocs.viewer.handler.ViewerImageHandler;
import com.groupdocs.viewer.licensing.License;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.Properties;

public class Utils {
    static {
        // Load the license as early as possible
        loadLicense();
    }

    public static ViewerConfig createViewerConfig() {
        ViewerConfig cfg = new ViewerConfig();
        cfg.setStoragePath(getProjectProperty("storage.path"));
        cfg.setCachePath(getProjectProperty("cache.path"));
        cfg.setTempPath(getProjectProperty("temp.path"));
        cfg.setUseCache(false);
        return cfg;
    }

    public static ViewerImageHandler createViewerImageHandler() {
        ViewerImageHandler handler = new ViewerImageHandler(createViewerConfig());
        return handler;
    }

    public static ViewerHtmlHandler createViewerHtmlHandler() {
        ViewerHtmlHandler handler = new ViewerHtmlHandler(createViewerConfig());
        return handler;
    }

    public synchronized static List<PageImage> loadPageImageList(ViewerImageHandler handler, String filename, ImageOptions options) {
        try {
            return handler.getPages(filename, options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }

    public static List<PageHtml> loadPageHtmlList(ViewerHtmlHandler handler, String filename, HtmlOptions options) {
        try {
            return handler.getPages(filename, options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }

    public static void loadLicense() {
        License l = new License();
        if (Files.exists(FileSystems.getDefault().getPath(getProjectProperty("license.path")))) {
            l.setLicense(getProjectProperty("license.path"));
            
        }
    }

    public static String getProjectProperty(String name) {
        Properties p = new Properties();
        try (InputStream i = Utils.class.getResourceAsStream("/project.properties")) {
            p.load(i);
        } catch (IOException e) {
            // Ignore
        }
        return p.getProperty(name);
    }

    public static int copyStream(InputStream input, OutputStream output) {
        try {
            return IOUtils.copy(input, output);
        } catch (IOException x) {
            throw new UncheckedIOException(x);
        }
    }

    public static int writeToResponse(InputStream input, ServletResponse response) {
        try {
            return Utils.copyStream(input, response.getOutputStream());
        } catch (IOException x) {
            throw new UncheckedIOException(x);
        }
    }
}

