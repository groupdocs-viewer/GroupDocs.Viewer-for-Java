package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_presentation_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

/**
 * This example demonstrates how to render FODP document into HTML, JPG, PNG, PDF.
 */
public class RenderingFodp {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingFodp");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "Fodp_result.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_FODP)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "Fodp_result.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_FODP)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "Fodp_result.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_FODP)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "Fodp_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_FODP)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
