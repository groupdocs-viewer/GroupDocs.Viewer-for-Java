package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;
import java.util.TimeZone;

/**
 * This example demonstrates how to set custom date-time format and time zone offset
 */
public class DateTimeFormatAndTimeZoneOffset {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("DateTimeFormatAndTimeZoneOffset");
        Path filePath = outputDirectory.resolve("output.html");

        try (Viewer viewer = new Viewer(inputFile)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(filePath);
            options.getEmailOptions().setDateTimeFormat("MM d yyyy HH:mm tt zzz");
            options.getEmailOptions().setTimeZoneOffset(TimeZone.getTimeZone("GMT+1"));

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
