package com.groupdocs.viewer.examples.advanced_usage.caching;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.ViewerSettings;
import com.groupdocs.viewer.caching.FileCache;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class UseCacheWhenProcessingDocuments {

    /**
     * This example demonstrates how to enable cache when render document.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("UseCacheWhenProcessingDocuments");
        String cachePath = new File(outputDirectory, "cache").getPath();
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        FileCache cache = new FileCache(cachePath);
        ViewerSettings settings = new ViewerSettings(cache);
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        StopWatch stopWatch = new StopWatch();
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX, settings)) {

            stopWatch.start();
            viewer.view(viewOptions);
            stopWatch.stop();

            System.out.println(String.format("Time taken on first call to View method '%s' (ms).",
                    stopWatch.getElapsedMilliseconds()));

            stopWatch.restart();
            viewer.view(viewOptions);
        }
        stopWatch.stop();

        System.out.println(String.format("Time taken on second call to View method '%s' (ms).",
                stopWatch.getElapsedMilliseconds()));
    }
}