package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

import java.util.TimeZone;

/**
 * This example demonstrates how to set custom date-time format and time zone offset
 */
public class DateTimeFormatAndTimeZoneOffset {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("DateTimeFormatAndTimeZoneOffset");
        String filePath = PathUtils.combine(outputDirectory, "output.html");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_EML)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(filePath);
            options.getEmailOptions().setDateTimeFormat("MM d yyyy HH:mm tt zzz");
            options.getEmailOptions().setTimeZoneOffset(TimeZone.getTimeZone("GMT+1"));

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
