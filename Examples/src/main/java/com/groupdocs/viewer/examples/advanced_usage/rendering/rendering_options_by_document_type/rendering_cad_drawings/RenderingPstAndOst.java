package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

/**
 * This example demonstrates how to render PST/OST document into HTML, JPG, PNG, PDF.
 */
public class RenderingPstAndOst {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingPstAndOst");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "PST_result.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PST)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "PST_result_{0}.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PST)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "PST_result_{0}.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PST)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "PST_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PST)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
