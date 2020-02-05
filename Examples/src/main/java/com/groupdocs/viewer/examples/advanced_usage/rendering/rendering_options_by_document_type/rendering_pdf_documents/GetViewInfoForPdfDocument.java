package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.PdfViewInfo;

import java.io.FileNotFoundException;

public class GetViewInfoForPdfDocument {

    /**
     * This example demonstrates how to get view info for PDF document.
     */

    public static void run() throws FileNotFoundException {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_PDF);
        PdfViewInfo viewInfo = (PdfViewInfo) viewer.getViewInfo(viewInfoOptions);
        viewer.close();

        System.out.println("Document type is: " + viewInfo.getFileType());
        System.out.println("Pages count: " + viewInfo.getPages().size());
        System.out.println("Printing allowed: " + viewInfo.isPrintingAllowed());

        System.out.println("\nView info retrieved successfully.");
    }
}