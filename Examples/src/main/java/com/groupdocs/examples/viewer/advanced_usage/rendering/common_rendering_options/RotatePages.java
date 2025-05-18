package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.Rotation;

import java.nio.file.Path;

public class RotatePages {

    /**
     * This example demonstrates how to rotate first page on 90 degree clockwise.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RotatePages");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.rotatePage(1, Rotation.ON_90_DEGREE);
        viewOptions.rotatePage(2, Rotation.ON_180_DEGREE);

        Viewer viewer = new Viewer(inputFile);
        viewer.view(viewOptions, 1, 2);
        viewer.close();

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}