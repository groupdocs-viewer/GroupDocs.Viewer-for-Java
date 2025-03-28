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
 * This example demonstrates how to render MS Project document into HTML, JPG, PNG, PDF with notes.
 */
public class RenderingNotes {
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingNotes");
        Path pageFilePathFormat = outputDirectory.resolve("mpp_result.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MPP)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.setRenderNotes(true);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = outputDirectory.resolve("mpp_{0}_result.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MPP)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            options.setRenderNotes(true);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = outputDirectory.resolve("mpp_{0}_result.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MPP)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.setRenderNotes(true);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = outputDirectory.resolve("mpp_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MPP)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            options.setRenderNotes(true);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
