package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.Rotation;
import com.groupdocs.viewer.utils.PathUtils;

import java.io.IOException;

/**
 * This example demonstrates how to rotate the first page 90-degree clockwise.
 */
public class FlipRotatePages {
    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("FlipRotatePages");
        String outputFilePath = PathUtils.combine(outputDirectory, "output.pdf");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX)) {
            PdfViewOptions viewOptions = new PdfViewOptions(outputFilePath);
            viewOptions.rotatePage(1, Rotation.ON_90_DEGREE);

            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
