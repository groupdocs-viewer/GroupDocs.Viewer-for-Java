package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render FODG/ODG document into HTML, JPG, PNG, PDF.
 */
public class RenderingFodgAndOdg {
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingFodgAndOdg");
        Path pageFilePathFormat = outputDirectory.resolve("fodg_result.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_FODG)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = outputDirectory.resolve("fodg_result.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_FODG)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = outputDirectory.resolve("fodg_result.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_FODG)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = outputDirectory.resolve("fodg_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_FODG)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
