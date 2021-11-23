package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

/**
 * This example demonstrates how to render Ai document into HTML, JPG, PNG, PDF.
 */
public class RenderingAi {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingAi");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "ai_result.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_AI)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "ai_result.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_AI)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "ai_result.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_AI)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = PathUtils.combine(outputDirectory, "ai_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_AI)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
