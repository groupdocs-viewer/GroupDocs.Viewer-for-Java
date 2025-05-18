package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how set output image size limits when rendering documents to JPG/PNG.
 */
public class SetImageSizeLimits {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("SetImageSizeLimits");
        Path outputFile = outputDirectory.resolve("result_image_size_limit.jpg");

        try (Viewer viewer = new Viewer(inputFile)) {
            JpgViewOptions options = new JpgViewOptions(outputFile);

            options.setMaxWidth(400);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
