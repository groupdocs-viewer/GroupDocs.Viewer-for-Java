package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.io.File;

public class RenderToJpg {

    /**
     * This example demonstrates how to render document into JPG image.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderToJpg");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.jpg").getPath();

        JpgViewOptions viewOptions = new JpgViewOptions(pageFilePathFormat);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}