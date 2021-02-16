package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;

import java.io.File;

public class RenderToPng {

    /**
     * This example demonstrates how to render document into PNG image.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderToPng");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.png").getPath();

        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}