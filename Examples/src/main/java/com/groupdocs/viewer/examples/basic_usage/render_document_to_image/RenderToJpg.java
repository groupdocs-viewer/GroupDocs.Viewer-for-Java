package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.io.File;
import java.nio.file.Path;

public class RenderToJpg {

    /**
     * This example demonstrates how to render document into JPG image.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderToJpg");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.jpg");

        JpgViewOptions viewOptions = new JpgViewOptions(pageFilePathFormat);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}