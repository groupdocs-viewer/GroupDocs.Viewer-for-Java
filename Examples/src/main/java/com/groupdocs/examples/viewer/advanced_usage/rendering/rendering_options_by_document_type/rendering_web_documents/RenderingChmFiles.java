package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render CHM document into HTML, JPG, PNG, PDF.
 */
public class RenderingChmFiles {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingChmFiles");
        Path pageFilePathFormat = outputDirectory.resolve("chm_result_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(inputFile)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.setRenderToSinglePage(true); // Enable it if you want to convert all CHM content to single page

            //viewer.view(options,1,2,3); // Convert only 1,2,3 pages
            viewer.view(options); // Convert all pages
        }

        // TO JPG
        pageFilePathFormat = outputDirectory.resolve("chm_result_{0}.jpg");

        try (Viewer viewer = new Viewer(inputFile)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options, 1, 2, 3); // Convert only 1,2,3 pages
            //viewer.view(options); // Convert all pages
        }

        // TO PNG
        pageFilePathFormat = outputDirectory.resolve("chm_result_{0}.png");

        try (Viewer viewer = new Viewer(inputFile)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options, 1, 2, 3); // Convert only 1,2,3 pages
            //viewer.view(options); // Convert all pages
        }

        // TO PDF
        pageFilePathFormat = outputDirectory.resolve("chm_result.pdf");

        try (Viewer viewer = new Viewer(inputFile)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options); // Convert all pages
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
