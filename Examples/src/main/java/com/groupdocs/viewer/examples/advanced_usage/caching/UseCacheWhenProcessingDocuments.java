package com.groupdocs.viewer.examples.advanced_usage.caching;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.ViewerSettings;
import com.groupdocs.viewer.caching.FileCache;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.IOException;

public class UseCacheWhenProcessingDocuments {

    /**
     * This example demonstrates how to enable cache when render document.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("UseCacheWhenProcessingDocuments");
        String cachePath = new File(outputDirectory, "cache").getPath();
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        FileCache cache = new FileCache(cachePath);
        ViewerSettings settings = new ViewerSettings(cache);
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX, settings);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        viewer.view(viewOptions);
        stopWatch.stop();

        System.out.println(String.format("Time taken on first call to View method '%s' (ms).",
                stopWatch.getElapsedMilliseconds()));

        stopWatch.restart();
        viewer.view(viewOptions);
        viewer.close();
        stopWatch.stop();

        System.out.println(String.format("Time taken on second call to View method '%s' (ms).",
                stopWatch.getElapsedMilliseconds()));
    }
}