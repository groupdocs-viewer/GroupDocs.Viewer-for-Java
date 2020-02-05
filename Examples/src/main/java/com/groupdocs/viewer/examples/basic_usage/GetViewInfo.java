package com.groupdocs.viewer.examples.basic_usage;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.ViewInfo;

import java.io.FileNotFoundException;

public class GetViewInfo {

    /**
     * This example demonstrates how to get basic information about document and document view.
     */

    public static void run() throws FileNotFoundException {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_PDF);
        ViewInfo info = viewer.getViewInfo(viewInfoOptions);
        viewer.close();

        System.out.println(info);
        
        System.out.println("\nView info retrieved successfully.");
    }
}