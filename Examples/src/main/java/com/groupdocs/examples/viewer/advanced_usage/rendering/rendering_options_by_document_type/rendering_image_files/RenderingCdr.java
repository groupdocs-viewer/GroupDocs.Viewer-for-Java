package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render CDR document into HTML, JPG, PNG, PDF.
 */
public class RenderingCdr {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingCdr");
        Path pageFilePathFormat = outputDirectory.resolve("cdr_result_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(inputFile)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);

            // To render 2nd image, just specify
            //viewer.view(options,2);
        }

        // TO JPG
        pageFilePathFormat = outputDirectory.resolve("cdr_result_{0}.jpg");

        try (Viewer viewer = new Viewer(inputFile)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);

            // To render 2nd image, just specify
            //viewer.view(options,2);
        }

        // TO PNG
        pageFilePathFormat = outputDirectory.resolve("cdr_result_{0}.png");

        try (Viewer viewer = new Viewer(inputFile)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);

            // To render 2nd image, just specify
            //viewer.view(options,2);
        }

        // TO PDF
        pageFilePathFormat = outputDirectory.resolve("cdr_result.pdf");

        try (Viewer viewer = new Viewer(inputFile)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);

            // By default all images will be rendered in output.pdf, to render only 2nd image in output PDF
            //viewer.view(options,2);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
