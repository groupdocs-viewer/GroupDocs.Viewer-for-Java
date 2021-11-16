package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

/**
 * This example demonstrates how to render Apple Numbers document into HTML, JPG, PNG, PDF.
 */
public class RenderingNumbers {
    public static void run() {

        String outputDirectory = Utils.getOutputDirectoryPath("RenderingNumbers");
        String pageFileFullPath = Utils.combinePaths(outputDirectory, "Numbers_result.html");

        // TO MULTI PAGES HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_NUMBERS)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFileFullPath);

            viewer.view(options);
        }

        // TO JPG
        pageFileFullPath = Utils.combinePaths(outputDirectory, "Numbers_result.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_NUMBERS)) {
            JpgViewOptions options = new JpgViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PNG
        pageFileFullPath = Utils.combinePaths(outputDirectory, "Numbers_result.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_NUMBERS)) {
            PngViewOptions options = new PngViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PDF
        pageFileFullPath = Utils.combinePaths(outputDirectory, "Numbers_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_NUMBERS)) {
            PdfViewOptions options = new PdfViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
