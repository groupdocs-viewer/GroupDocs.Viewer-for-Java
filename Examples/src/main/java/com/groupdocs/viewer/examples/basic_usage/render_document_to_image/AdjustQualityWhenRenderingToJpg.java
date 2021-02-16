package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.io.File;

public class AdjustQualityWhenRenderingToJpg {

    /**
     * This example demonstrates how to adjust quality of the output JPG image.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustQualityWhenRenderingToJpg");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.jpg").getPath();

        JpgViewOptions viewOptions = new JpgViewOptions(pageFilePathFormat);
        byte quality = 50;
        viewOptions.setQuality(quality);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}