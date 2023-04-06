package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;

import java.io.File;
import java.nio.file.Path;

public class RenderToPng {

    /**
     * This example demonstrates how to render document into PNG image.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderToPng");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.png");

        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}