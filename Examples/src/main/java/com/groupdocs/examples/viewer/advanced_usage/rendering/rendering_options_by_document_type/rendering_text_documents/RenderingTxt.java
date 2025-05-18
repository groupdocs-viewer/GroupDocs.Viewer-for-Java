package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_text_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render TXT document into HTML, JPG, PNG, PDF.
 */
public class RenderingTxt {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingTxt");
        Path pageFileFullPath = outputDirectory.resolve("Txt_result.html");

        // TO MULTI PAGES HTML
        try (Viewer viewer = new Viewer(inputFile)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFileFullPath);

            viewer.view(options);
        }

        pageFileFullPath = outputDirectory.resolve("Txt_result_single_page.html");

        // TO SINGLE HTML
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_2_TXT)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFileFullPath);
            options.setRenderToSinglePage(true);

            viewer.view(options);
        }

        // TO JPG
        pageFileFullPath = outputDirectory.resolve("Txt_result.jpg");

        try (Viewer viewer = new Viewer(inputFile)) {
            JpgViewOptions options = new JpgViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PNG
        pageFileFullPath = outputDirectory.resolve("Txt_result.png");

        try (Viewer viewer = new Viewer(inputFile)) {
            PngViewOptions options = new PngViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PDF
        pageFileFullPath = outputDirectory.resolve("Txt_result.pdf");

        try (Viewer viewer = new Viewer(inputFile)) {
            PdfViewOptions options = new PdfViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
