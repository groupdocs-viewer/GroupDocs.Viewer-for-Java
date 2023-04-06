package com.groupdocs.viewer.examples.basic_usage.extract_text;

import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.options.LoadOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.Line;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.PdfViewInfo;

import java.io.InputStream;

public class ExtractTextFromPdfFile {

    /**
     * This example demonstrates how to extract text from a PDF file
     */
    public static void run() {
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PDF)) {
            ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
            viewInfoOptions.setExtractText(true);
            PdfViewInfo viewInfo = (PdfViewInfo) viewer.getViewInfo(viewInfoOptions);

            // Retrieve text from the PDF file.
            System.out.println("Extracted document text:");
            for (Page page : viewInfo.getPages()) {
                for (Line line : page.getLines()) {
                    System.out.println(line.getValue());
                }
            }
        }

        System.out.println("\nText from PDF extracted successfully.");
    }
}