package com.groupdocs.examples.viewer.basic_usage.render_document_to_image;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.nio.file.Path;

public class AdjustQualityWhenRenderingToJpg {

    /**
     * This example demonstrates how to adjust quality of the output JPG image.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("AdjustQualityWhenRenderingToJpg");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.jpg");

        JpgViewOptions viewOptions = new JpgViewOptions(pageFilePathFormat);
        byte quality = 50;
        viewOptions.setQuality(quality);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}