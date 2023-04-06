package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to render CMX document into HTML, JPG, PNG, PDF.
 */
public class RenderingCmx {
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingCmx");
        Path pageFilePathFormat = outputDirectory.resolve("cmx_result_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_CMX)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);

            // To render 2nd image, just specify
            //viewer.view(options,2);
        }

        // TO JPG
        pageFilePathFormat = outputDirectory.resolve("cmx_result_{0}.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_CMX)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);

            // To render 2nd image, just specify
            //viewer.view(options,2);
        }

        // TO PNG
        pageFilePathFormat = outputDirectory.resolve("cmx_result_{0}.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_CMX)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);

            // To render 2nd image, just specify
            //viewer.view(options,2);
        }

        // TO PDF
        pageFilePathFormat = outputDirectory.resolve("cmx_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_CMX)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);

            // By default all images will be rendered in output.pdf, to render only 2nd image in output PDF
            //viewer.view(options,2);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
