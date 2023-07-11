package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_visio_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render Visio documents figures into HTML, JPG, PNG, PDF.
 */
public class RenderingVisioDocumentsFigures {

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingCmx");
        Path pageFilePathFormat = outputDirectory.resolve("result_page.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_VISIO)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.getVisioRenderingOptions().setRenderFiguresOnly(true);
            options.getVisioRenderingOptions().setFigureWidth(250);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = outputDirectory.resolve("visio_result.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_VISIO)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            options.getVisioRenderingOptions().setRenderFiguresOnly(true);
            options.getVisioRenderingOptions().setFigureWidth(250);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = outputDirectory.resolve("visio_result.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_VISIO)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.getVisioRenderingOptions().setRenderFiguresOnly(true);
            options.getVisioRenderingOptions().setFigureWidth(250);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = outputDirectory.resolve("visio_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_VISIO)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            options.getVisioRenderingOptions().setRenderFiguresOnly(true);
            options.getVisioRenderingOptions().setFigureWidth(250);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
