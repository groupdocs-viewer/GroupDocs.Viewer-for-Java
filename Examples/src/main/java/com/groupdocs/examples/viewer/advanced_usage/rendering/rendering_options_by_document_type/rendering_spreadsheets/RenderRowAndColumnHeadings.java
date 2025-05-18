package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render row and column headings.
 */
public class RenderRowAndColumnHeadings {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderRowAndColumnHeadings");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(inputFile)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO JPG
        pageFilePathFormat = outputDirectory.resolve("page_{0}.jpg");

        try (Viewer viewer = new Viewer(inputFile)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO PNG
        pageFilePathFormat = outputDirectory.resolve("page_{0}.png");

        try (Viewer viewer = new Viewer(inputFile)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO PDF
        pageFilePathFormat = outputDirectory.resolve("output.pdf");

        try (Viewer viewer = new Viewer(inputFile)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
