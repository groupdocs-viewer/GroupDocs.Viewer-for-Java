package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.Rotation;

import java.io.File;

public class RotatePages {

    /**
     * This example demonstrates how to rotate first page on 90 degree clockwise.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RotatePages");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.rotatePage(1, Rotation.ON_90_DEGREE);
        viewOptions.rotatePage(2, Rotation.ON_180_DEGREE);

        Viewer viewer = new Viewer(TestFiles.SAMPLE_PDF);
        viewer.view(viewOptions, 1, 2);
        viewer.close();

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}