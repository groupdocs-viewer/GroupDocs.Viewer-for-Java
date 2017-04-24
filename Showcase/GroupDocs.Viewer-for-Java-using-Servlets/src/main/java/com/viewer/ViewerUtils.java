package com.viewer;

import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.converter.options.ConvertImageFileType;
import com.groupdocs.viewer.domain.FileData;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.options.DocumentInfoOptions;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;
import com.groupdocs.viewer.handler.ViewerImageHandler;
import com.groupdocs.viewer.licensing.License;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Properties;

public class ViewerUtils {

    public static final String STORAGE_PATH = getProjectBaseDir().resolve("src/main/webapp/storage").toString();
    public static final String TEMP_PATH = getProjectBaseDir().resolve("src/main/webapp/storage/temp").toString();
    public static final Path LICENSE_PATH = getProjectBaseDir().resolve("GroupDocs.Total.Java.lic");
    private static ViewerHtmlHandler _htmlHandler;
    private static ViewerImageHandler _imageHandler;

    static {
        License l = new com.groupdocs.viewer.licensing.License();
        if (LICENSE_PATH != null && Files.exists(LICENSE_PATH)) {
            l.setLicense(LICENSE_PATH.toString());
        }
    }

    public static Path getProjectBaseDir() {
        Properties props = new Properties();
        try {
            InputStream i = ViewerUtils.class.getResourceAsStream("/project.properties");
            props.load(i);
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
        return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
    }

    public static ViewerHtmlHandler getViewerHtmlHandler() {
        if (_htmlHandler == null) {
            ViewerConfig htmlConfig = new ViewerConfig();
            htmlConfig.setStoragePath(STORAGE_PATH);
            htmlConfig.setTempPath(TEMP_PATH);

            htmlConfig.setUseCache(true);
            _htmlHandler = new ViewerHtmlHandler(htmlConfig);
        }

        return _htmlHandler;
    }

    public static ViewerImageHandler getViewerImageHandler() {
        if (_imageHandler == null) {
            ViewerConfig imageConfig = new ViewerConfig();
            imageConfig.setStoragePath(STORAGE_PATH);
            imageConfig.setTempPath(TEMP_PATH);
            imageConfig.setUseCache(true);
            _imageHandler = new ViewerImageHandler(imageConfig);

        }

        return _imageHandler;
    }

    public static FileData factoryFileData(String path) throws ServletException {
        DocumentInfoContainer docInfo = null;
        try {
            docInfo = ViewerUtils.getViewerHtmlHandler().getDocumentInfo(new DocumentInfoOptions(path));
        } catch (Exception x) {
            throw new ServletException(x);
        }

        int maxWidth = 0;
        int maxHeight = 0;
        for (PageData pageData : docInfo.getPages()) {
            if (pageData.getHeight() > maxHeight) {
                maxHeight = pageData.getHeight();
                maxWidth = pageData.getWidth();
            }
        }
        FileData fileData = new FileData();

        fileData.setDateCreated(new Date());
        fileData.setDateModified(docInfo.getLastModificationDate());
        fileData.setPageCount(docInfo.getPages().size());
        fileData.setPages(docInfo.getPages());
        fileData.setMaxWidth(maxWidth);
        fileData.setMaxHeight(maxHeight);

        return fileData;
    }

    public static DocumentInfoContainer factoryDocumentInfoContainerFromImageHandler(String guid) {
        DocumentInfoOptions documentInfoOptions = new DocumentInfoOptions(guid);
        try {
            return ViewerUtils.getViewerImageHandler().getDocumentInfo(documentInfoOptions);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

    }

    public static DocumentInfoContainer factoryDocumentInfoContainerFromHtmlHandler(String guid) {
        DocumentInfoOptions documentInfoOptions = new DocumentInfoOptions(guid);
        try {
            return ViewerUtils.getViewerHtmlHandler().getDocumentInfo(documentInfoOptions);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

    }

    public static String getContentTypeByExtention(ConvertImageFileType convertImageFileType) {
        String contentType;
        switch (convertImageFileType) {
            case JPG:
                contentType = "image/jpeg";
                break;
            case BMP:
                contentType = "*/*";
                break;
            case PNG:
                contentType = "image/png";
                break;
            default:
                throw new IllegalArgumentException();
        }

        return contentType;
    }

    public static void copyStream(InputStream in, OutputStream out) throws IOException {
        IOUtils.copy(in, out);
    }
}

