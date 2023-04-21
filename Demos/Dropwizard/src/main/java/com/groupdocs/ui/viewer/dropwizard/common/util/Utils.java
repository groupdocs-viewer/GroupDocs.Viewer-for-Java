package com.groupdocs.ui.viewer.dropwizard.common.util;

import com.groupdocs.ui.viewer.dropwizard.common.exception.PasswordExceptions;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    /**
     * Get correct message for security exceptions
     */
    public static String getExceptionMessage(String password) {
        return password == null || password.isEmpty() ? PasswordExceptions.PASSWORD_REQUIRED : PasswordExceptions.INCORRECT_PASSWORD;
    }

    public static MediaType detectMediaType(String fileName) {
        if (fileName.contains(".")) {
            final String extension = fileName.substring(fileName.lastIndexOf("."));
            return MediaType.valueOf(MediaTypes.detectMediaTypeForWeb(extension));
        }
        return MediaType.APPLICATION_OCTET_STREAM_TYPE;
    }

    public static String normalizePathToGuid(String filesDirectory, String path) {
        final Path relativePath = Paths.get(filesDirectory).relativize(Paths.get(path));
        return relativePath.toString().replace(File.separatorChar, '/');
    }

    public static String normalizeGuidToPath(String path) {
        return path.replace('/', File.separatorChar);
    }
}
