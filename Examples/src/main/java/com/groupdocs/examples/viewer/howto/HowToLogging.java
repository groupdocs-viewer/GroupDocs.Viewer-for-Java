package com.groupdocs.examples.viewer.howto;

//import com.groupdocs.foundation.logging.ConsoleLogger;

import com.groupdocs.examples.viewer.SampleFiles;
import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.ViewerSettings;
import com.groupdocs.viewer.logging.FileLogger;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to log to file or console.
 */
public class HowToLogging {
    /**
     * Logging to console.
     */
    public static void toConsole() {
//        ViewerSettings viewerSettings = new ViewerSettings(new ConsoleLogger());
//
//        Path outputDirectory = FilesUtils.makeOutputPath("HowToLogging");
//        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");
//
//        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_PDF, viewerSettings)) {
//            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
//
//            viewer.view(options);
//        }
//
//        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    /**
     * Logging to file.
     */
    public static void toFile() {
        ViewerSettings viewerSettings = new ViewerSettings(new FileLogger("output.log"));

        Path outputDirectory = FilesUtils.makeOutputPath("HowToLogging");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_PDF, viewerSettings)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
