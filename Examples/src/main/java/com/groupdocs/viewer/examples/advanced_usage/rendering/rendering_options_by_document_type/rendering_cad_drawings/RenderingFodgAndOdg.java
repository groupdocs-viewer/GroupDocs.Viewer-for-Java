package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

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
 * This example demonstrates how to render FODG/ODG document into HTML, JPG, PNG, PDF.
 */
public class RenderingFodgAndOdg {
    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingFodgAndOdg");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "fodg_result.html");

        // TO HTML
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_FODG)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "fodg_result.jpg");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_FODG)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "fodg_result.png");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_FODG)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = PathUtils.combine(outputDirectory, "fodg_result.pdf");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_FODG)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
