package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

import java.io.IOException;

/**
 * This example demonstrates how to render row and column headings.
 */
public class RenderRowAndColumnHeadings {
    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderRowAndColumnHeadings");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_XLSX)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO JPG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.jpg");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_XLSX)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO PNG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.png");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_XLSX)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        // TO PDF
        pageFilePathFormat = PathUtils.combine(outputDirectory, "output.pdf");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_XLSX)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            options.getSpreadsheetOptions().setRenderHeadings(true);

            viewer.view(options, 1, 2, 3);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
