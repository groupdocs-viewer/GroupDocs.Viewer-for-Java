package com.groupdocs.viewer.examples.advanced_usage.caching;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.ViewerSettings;
import com.groupdocs.viewer.caching.Cache;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.examples.advanced_usage.caching.jackson.JacksonCache;
import com.groupdocs.viewer.examples.advanced_usage.caching.jackson.JacksonCacheableFactory;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.results.FileInfo;

import java.nio.file.Path;

public class UseCustomCacheImplementation {

    /**
     * This example demonstrates how to create custom cache and how to use it.
     */
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("UseCustomCacheImplementation");
        String pageFilePathFormat = outputDirectory + "\\page_{0}.html";

        Cache cache = new JacksonCache();

        // Setting factory before  try custom models for caching
        // You still can use embedded implementation of models (*Impl) if you don't need
        // any specific annotations for serialization. In this way no need to set the factory
        // Embedded models are just implements Serializable interface
        CacheableFactory.setInstance(new JacksonCacheableFactory());

        ViewerSettings settings = new ViewerSettings(cache);
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX, settings)) {

            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            long stopWatch = System.currentTimeMillis();
            viewer.view(options);
            stopWatch = System.currentTimeMillis() - stopWatch;
            System.out.println("Time taken on first call to View method " + stopWatch + " (ms).");
            stopWatch = System.currentTimeMillis();
            viewer.view(options);
            stopWatch = System.currentTimeMillis() - stopWatch;
            System.out.println("Time taken on second call to View method " + stopWatch + " (ms).");

            final FileInfo fileInfo = viewer.getFileInfo();
            System.out.println(fileInfo);

            System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
        }
    }
}
