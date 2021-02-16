package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_text_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

/**
 * This example demonstrates how to render TXT document into HTML, JPG, PNG, PDF.
 */
public class RenderingTxt {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingTxt");
        String pageFileFullPath = Utils.combinePaths(outputDirectory, "Txt_result.html");

        // TO MULTI PAGES HTML
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_TXT)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFileFullPath);

            viewer.view(options);
        }

        pageFileFullPath = Utils.combinePaths(outputDirectory, "Txt_result_single_page.html");

        // TO SINGLE HTML
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_2_TXT)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFileFullPath);
            options.setRenderSinglePage(true);

            viewer.view(options);
        }

        // TO JPG
        pageFileFullPath = Utils.combinePaths(outputDirectory, "Txt_result.jpg");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_TXT)) {
            JpgViewOptions options = new JpgViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PNG
        pageFileFullPath = Utils.combinePaths(outputDirectory, "Txt_result.png");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_TXT)) {
            PngViewOptions options = new PngViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PDF
        pageFileFullPath = Utils.combinePaths(outputDirectory, "Txt_result.pdf");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_TXT)) {
            PdfViewOptions options = new PdfViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
