package com.groupdocs.viewer.examples.howto;

//import com.groupdocs.foundation.logging.ConsoleLogger;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.ViewerSettings;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.logging.FileLogger;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

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
//        String outputDirectory = Utils.getOutputDirectoryPath("HowToLogging");
//        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.html");
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

        String outputDirectory = Utils.getOutputDirectoryPath("HowToLogging");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.html");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PDF, viewerSettings)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}