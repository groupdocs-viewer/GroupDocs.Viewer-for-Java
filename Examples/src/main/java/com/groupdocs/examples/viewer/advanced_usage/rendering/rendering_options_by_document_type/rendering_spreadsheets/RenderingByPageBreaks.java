package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.SpreadsheetOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render spreadsheets by page breaks.
 * More details at https://docs.groupdocs.com/viewer/net/render-spreadsheets-by-page-breaks/
 */
public class RenderingByPageBreaks {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingByPageBreaks");
        Path outputFilePath = outputDirectory.resolve("output.pdf");

        try (Viewer viewer = new Viewer(inputFile)) {
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
