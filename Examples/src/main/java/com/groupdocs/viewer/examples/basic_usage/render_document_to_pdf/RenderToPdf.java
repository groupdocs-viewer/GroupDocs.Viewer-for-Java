package com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.io.File;

public class RenderToPdf {

    /**
     * This example demonstrates how to render document into PDF file.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderToPdf");
        String outputFilePath = new File(outputDirectory, "output.pdf").getPath();

        PdfViewOptions viewOptions = new PdfViewOptions(outputFilePath);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}