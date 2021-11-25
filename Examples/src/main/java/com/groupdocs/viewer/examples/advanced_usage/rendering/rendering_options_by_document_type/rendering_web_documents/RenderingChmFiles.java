package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

/**
 * This example demonstrates how to render CHM document into HTML, JPG, PNG, PDF.
 */
public class RenderingChmFiles {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingChmFiles");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "chm_result_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_CHM)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.setRenderToSinglePage(true); // Enable it if you want to convert all CHM content to single page

            //viewer.view(options,1,2,3); // Convert only 1,2,3 pages
            viewer.view(options); // Convert all pages
        }

        // TO JPG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "chm_result_{0}.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_CHM)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options, 1, 2, 3); // Convert only 1,2,3 pages
            //viewer.view(options); // Convert all pages
        }

        // TO PNG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "chm_result_{0}.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_CHM)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options, 1, 2, 3); // Convert only 1,2,3 pages
            //viewer.view(options); // Convert all pages
        }

        // TO PDF
        pageFilePathFormat = PathUtils.combine(outputDirectory, "chm_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_CHM)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options); // Convert all pages
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
