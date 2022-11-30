package com.groupdocs.ui.viewer.spring.common.util;

import com.groupdocs.ui.viewer.spring.common.config.ServerConfiguration;
import com.groupdocs.ui.viewer.spring.common.exception.TotalGroupDocsException;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import static com.groupdocs.ui.viewer.spring.common.exception.PasswordExceptions.INCORRECT_PASSWORD;
import static com.groupdocs.ui.viewer.spring.common.exception.PasswordExceptions.PASSWORD_REQUIRED;

public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * Set local port from request to config
     *
     * @param request
     * @param server
     */
    public static void setLocalPort(HttpServletRequest request, ServerConfiguration server) {
        if (server.getHttpPort() == null) {
            server.setHttpPort(request.getLocalPort());
        }
    }

    /**
     * Get correct message for security exceptions
     *
     * @param password
     * @return
     */
    public static String getExceptionMessage(String password) {
        return StringUtils.isEmpty(password) ? PASSWORD_REQUIRED : INCORRECT_PASSWORD;
    }

    /**
     * Upload the file
     *
     * @param documentStoragePath path for uploading the file
     * @param content             file data
     * @param url                 url of file
     * @param rewrite             flag of rewriting the file
     * @return path to uploaded file
     */
    public static String uploadFile(String documentStoragePath, MultipartFile content, String url, Boolean rewrite) {
        String filePath;
        try {
            String fileName;
            // save from file content
            if (StringUtils.isEmpty(url)) {
                fileName = content.getOriginalFilename();
                try (InputStream inputStream = content.getInputStream()) {
                    filePath = uploadFileInternal(inputStream, documentStoragePath, fileName, rewrite);
                } catch (Exception ex) {
                    logger.error("Exception occurred while uploading document", ex);
                    throw new TotalGroupDocsException(ex.getMessage(), ex);
                }
            } else { // save from url
                URL fileUrl = new URL(url);
                try (InputStream inputStream = fileUrl.openStream()) {
                    fileName = FilenameUtils.getName(fileUrl.getPath());
                    filePath = uploadFileInternal(inputStream, documentStoragePath, fileName, rewrite);
                } catch (Exception ex) {
                    logger.error("Exception occurred while uploading document", ex);
                    throw new TotalGroupDocsException(ex.getMessage(), ex);
                }
            }
        } catch (Exception ex) {
            logger.error("Exception occurred while uploading document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
        return filePath;
    }

    /**
     * Upload file from input stream
     *
     * @param uploadedInputStream input stream of file
     * @param documentStoragePath path to storage
     * @param fileName            name of file
     * @param rewrite             flag for rewriting
     * @return path to file
     * @throws IOException
     */
    public static String uploadFileInternal(InputStream uploadedInputStream, String documentStoragePath, String fileName, boolean rewrite) throws IOException {
        String filePath = String.format("%s%s%s", documentStoragePath, File.separator, fileName);
        File file = new File(filePath);
        // check rewrite mode
        if (rewrite) {
            // save file with rewrite if exists
            Files.copy(uploadedInputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return filePath;
        } else {
            if (file.exists()) {
                // get file with new name
                file = getFreeFileName(documentStoragePath, fileName);
            }
            // save file without rewriting
            Path path = file.toPath();
            Files.copy(uploadedInputStream, path);
            return path.toString();
        }
    }

    /**
     * Rename file if exist
     *
     * @param directory directory where files are located
     * @param fileName  file name
     * @return new file with new file name
     */
    public static File getFreeFileName(String directory, String fileName) {
        File file = null;
        try {
            File folder = new File(directory);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                int number = i + 1;
                String newFileName = FilenameUtils.removeExtension(fileName) + "-Copy(" + number + ")." + FilenameUtils.getExtension(fileName);
                file = new File(directory + File.separator + newFileName);
                if (!file.exists()) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public static MediaType detectMediaType(String fileName) {
        if (fileName.contains(".")) {
            final String extension = fileName.substring(fileName.lastIndexOf("."));
            return MediaType.parseMediaType(MediaTypes.detectMediaTypeForWeb(extension));
        }
        return MediaType.APPLICATION_OCTET_STREAM;
    }
}
