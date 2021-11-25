package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

/**
 * This example demonstrates how to render row and column headings.
 */
public class RenderRowAndColumnHeadings {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderRowAndColumnHeadings");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "page_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO JPG
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "page_{0}.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO PNG
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "page_{0}.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO PDF
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "output.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
