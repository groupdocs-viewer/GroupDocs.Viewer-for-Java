package com.groupdocs.ui.viewer.util;

import com.groupdocs.ui.common.exception.PasswordExceptions;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ViewInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.util.List;

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
