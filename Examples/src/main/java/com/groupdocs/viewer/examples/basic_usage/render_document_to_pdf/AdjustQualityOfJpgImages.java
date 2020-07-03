package com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.io.File;
import java.io.IOException;

public class AdjustQualityOfJpgImages {

    /**
     * This example demonstrates how to adjust quality of JPG images of the output PDF document.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustQualityOfJpgImages");
        String filePath = new File(outputDirectory, "output.pdf").getPath();

        PdfViewOptions viewOptions = new PdfViewOptions(filePath);
        byte quality = 10;
        viewOptions.setJpgQuality(quality);

        Viewer viewer = new Viewer(SampleFiles.JPG_IMAGE_PPTX);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}