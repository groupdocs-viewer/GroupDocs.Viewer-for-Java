package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_text_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render TXT document into HTML, JPG, PNG, PDF.
 */
public class RenderingTxt {
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingTxt");
        Path pageFileFullPath = outputDirectory.resolve("Txt_result.html");

        // TO MULTI PAGES HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_TXT)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFileFullPath);

            viewer.view(options);
        }

        pageFileFullPath = outputDirectory.resolve("Txt_result_single_page.html");

        // TO SINGLE HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_2_TXT)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFileFullPath);
            options.setRenderToSinglePage(true);

            viewer.view(options);
        }

        // TO JPG
        pageFileFullPath = outputDirectory.resolve("Txt_result.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_TXT)) {
            JpgViewOptions options = new JpgViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PNG
        pageFileFullPath = outputDirectory.resolve("Txt_result.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_TXT)) {
            PngViewOptions options = new PngViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PDF
        pageFileFullPath = outputDirectory.resolve("Txt_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_TXT)) {
            PdfViewOptions options = new PdfViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
