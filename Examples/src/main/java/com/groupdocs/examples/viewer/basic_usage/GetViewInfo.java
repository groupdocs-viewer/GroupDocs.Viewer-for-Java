package com.groupdocs.examples.viewer.basic_usage;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.ViewInfo;

import java.nio.file.Path;

public class GetViewInfo {

    /**
     * This example demonstrates how to get basic information about document and document view.
     */

    public static void run(Path inputFile) {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

        ViewInfo info;
        try (Viewer viewer = new Viewer(inputFile)) {
            info = viewer.getViewInfo(viewInfoOptions);
        }

        System.out.println(info);

        System.out.println("\nView info retrieved successfully.");
    }
}