package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.Rotation;

import java.nio.file.Path;

/**
 * This example demonstrates how to rotate the first page 90-degree clockwise.
 */
public class FlipRotatePages {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("FlipRotatePages");
        Path outputFilePath = outputDirectory.resolve("output.pdf");

        try (Viewer viewer = new Viewer(inputFile)) {
            PdfViewOptions viewOptions = new PdfViewOptions(outputFilePath);
            viewOptions.rotatePage(1, Rotation.ON_90_DEGREE);

            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
