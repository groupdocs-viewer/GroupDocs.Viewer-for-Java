package com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.io.File;
import java.io.IOException;

public class RenderToPdf {

    /**
     * This example demonstrates how to render document into PDF file.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderToPdf");
        String outputFilePath = new File(outputDirectory, "output.pdf").getPath();

        PdfViewOptions viewOptions = new PdfViewOptions(outputFilePath);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}