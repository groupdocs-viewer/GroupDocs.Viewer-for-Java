package com.groupdocs.ui.viewer.spring.common.resources;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public abstract class Resources {

    private static final ZoneId GMT = ZoneId.of("GMT");

    /**
     * Date formats with time zone as specified in the HTTP RFC.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-7.1.1.1">Section 7.1.1.1 of RFC 7231</a>
     */
    private static final DateTimeFormatter[] DATE_FORMATTERS = new DateTimeFormatter[]{
            DateTimeFormatter.RFC_1123_DATE_TIME,
            DateTimeFormatter.ofPattern("EEEE, dd-MMM-yy HH:mm:ss zz", Locale.US),
            DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy", Locale.US).withZone(GMT)
    };

    /**
     * Get headers for downloading files
     */
    private static Map<String, List<String>> createFileDownloadHeaders(String fileName, Long fileLength, String mediaType) {
        Map<String, List<String>> httpHeaders = new HashMap<>();
        httpHeaders.put("Content-disposition", Collections.singletonList("attachment; filename=" + fileName));
        httpHeaders.put("Content-Type", Collections.singletonList(mediaType));
        httpHeaders.put("Content-Description", Collections.singletonList("File Transfer"));
        httpHeaders.put("Content-Transfer-Encoding", Collections.singletonList("binary"));
        httpHeaders.put("Expires", Collections.singletonList(formatDate(0)));
        httpHeaders.put("Cache-Control", Collections.singletonList("must-revalidate"));
        httpHeaders.put("Pragma", Collections.singletonList("public"));
        if (fileLength != null) {
            httpHeaders.put("Content-Length", Collections.singletonList(Long.toString(fileLength)));
        }
        return httpHeaders;
    }

    private static String formatDate(long date) {
        Instant instant = Instant.ofEpochMilli(date);
        ZonedDateTime time = ZonedDateTime.ofInstant(instant, GMT);
        return DATE_FORMATTERS[0].format(time);
    }

    /**
     * Fill header HTTP response with file data
     */
    public void addFileDownloadHeaders(HttpServletResponse response, String fileName, Long fileLength) {
        Map<String, List<String>> fileDownloadHeaders = createFileDownloadHeaders(fileName, fileLength, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        for (Map.Entry<String, List<String>> entry : fileDownloadHeaders.entrySet()) {
            for (String value : entry.getValue()) {
                response.addHeader(entry.getKey(), value);
            }
        }
    }

}