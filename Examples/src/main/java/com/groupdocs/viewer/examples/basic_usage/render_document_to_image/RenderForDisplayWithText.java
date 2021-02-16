package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;

import java.io.File;

public class RenderForDisplayWithText {

    /**
     * This example demonstrates how to render document so extracted text may be
     * placed as top layer over the image.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderForDisplayWithText");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.png").getPath();

        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);
        viewOptions.setExtractText(true);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}