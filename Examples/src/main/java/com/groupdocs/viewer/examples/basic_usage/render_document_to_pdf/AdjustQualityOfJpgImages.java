package com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.io.File;

public class AdjustQualityOfJpgImages {

    /**
     * This example demonstrates how to adjust quality of JPG images of the output PDF document.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustQualityOfJpgImages");
        String filePath = new File(outputDirectory, "output.pdf").getPath();

        PdfViewOptions viewOptions = new PdfViewOptions(filePath);
        byte quality = 10;
        viewOptions.setJpgQuality(quality);

        try (Viewer viewer = new Viewer(TestFiles.JPG_IMAGE_PPTX)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}