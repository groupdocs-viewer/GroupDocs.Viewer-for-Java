package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.io.File;
import java.nio.file.Path;

public class AdjustQualityWhenRenderingToJpg {

    /**
     * This example demonstrates how to adjust quality of the output JPG image.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("AdjustQualityWhenRenderingToJpg");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.jpg");

        JpgViewOptions viewOptions = new JpgViewOptions(pageFilePathFormat);
        byte quality = 50;
        viewOptions.setQuality(quality);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}