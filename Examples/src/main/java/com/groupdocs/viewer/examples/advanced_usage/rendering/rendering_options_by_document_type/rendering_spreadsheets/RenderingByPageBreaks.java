package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.SpreadsheetOptions;
import com.groupdocs.viewer.utils.PathUtils;

/**
 * This example demonstrates how to render spreadsheets by page breaks.
 * More details at https://docs.groupdocs.com/viewer/net/render-spreadsheets-by-page-breaks/
 */
public class RenderingByPageBreaks {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingByPageBreaks");
        String outputFilePath = PathUtils.combine(outputDirectory, "output.pdf");

        try (Viewer viewer = new Viewer(TestFiles.PAGE_BREAKS_XLSX)) {
            PdfViewOptions viewOptions = new PdfViewOptions(outputFilePath);
            viewOptions.setSpreadsheetOptions(SpreadsheetOptions.forRenderingByPageBreaks());

            // Enable rendering gird lines and headings to check that proper areas are rendered
            viewOptions.getSpreadsheetOptions().setRenderGridLines(true);
            viewOptions.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
