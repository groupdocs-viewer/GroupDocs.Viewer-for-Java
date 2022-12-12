package com.groupdocs.ui.viewer.dropwizard.common.util;

import com.groupdocs.ui.viewer.dropwizard.common.exception.PasswordExceptions;

import javax.ws.rs.core.MediaType;

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
}
