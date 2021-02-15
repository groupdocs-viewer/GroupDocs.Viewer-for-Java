package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.PdfViewInfo;

public class GetViewInfoForPdfDocument {

    /**
     * This example demonstrates how to get view info for PDF document.
     */

    public static void run() {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

        PdfViewInfo viewInfo;
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_PDF)) {
            viewInfo = (PdfViewInfo) viewer.getViewInfo(viewInfoOptions);
        }

        System.out.println("Document type is: " + viewInfo.getFileType());
        System.out.println("Pages count: " + viewInfo.getPages().size());
        System.out.println("Printing allowed: " + viewInfo.isPrintingAllowed());

        System.out.println("\nView info retrieved successfully.");
    }
}