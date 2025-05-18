package com.groupdocs.examples.viewer.advanced_usage.caching;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.ViewerSettings;
import com.groupdocs.viewer.caching.FileCache;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class UseCacheWhenProcessingDocuments {

    /**
     * This example demonstrates how to enable cache when render document.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("UseCacheWhenProcessingDocuments");
        Path cachePath = outputDirectory.resolve("cache");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        FileCache cache = new FileCache(cachePath);
        ViewerSettings settings = new ViewerSettings(cache);
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        StopWatch stopWatch = new StopWatch();
        try (Viewer viewer = new Viewer(inputFile, settings)) {

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