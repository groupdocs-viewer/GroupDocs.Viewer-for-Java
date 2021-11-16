package com.groupdocs.viewer.examples.basic_usage;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.ViewInfo;

public class GetViewInfo {

    /**
     * This example demonstrates how to get basic information about document and document view.
     */

    public static void run() {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

        ViewInfo info;
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PDF)) {
            info = viewer.getViewInfo(viewInfoOptions);
        }

        System.out.println(info);

        System.out.println("\nView info retrieved successfully.");
    }
}