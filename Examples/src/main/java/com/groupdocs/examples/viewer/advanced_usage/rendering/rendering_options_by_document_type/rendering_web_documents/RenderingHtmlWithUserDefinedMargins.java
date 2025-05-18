package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render HTML files with user defined margins.
 */
public class RenderingHtmlWithUserDefinedMargins {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingHtmlWithUserDefinedMargins");
        Path pageFilePathFormat = outputDirectory.resolve("html_render_margins_page_{0}.jpg");

            /*
             You can adjust margins (top,bottom,left,right) of final document by setting following properties in
             options.WordProcessingOptions:

              LeftMargin
              RightMargin
              TopMargin
              BottomMargin

              Default values in points are:
               LeftMargin = RightMargin = 5
               TopMargin = BottomMargin = 72
             */

        // TO JPG
        try (Viewer viewer = new Viewer(inputFile)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            options.getWordProcessingOptions().setLeftMargin(40d);
            options.getWordProcessingOptions().setRightMargin(40d);
            options.getWordProcessingOptions().setTopMargin(40d);
            options.getWordProcessingOptions().setBottomMargin(40d);

            viewer.view(options);
        }

        pageFilePathFormat = outputDirectory.resolve("html_render_margins_page_{0}.png");

        // TO PNG
        try (Viewer viewer = new Viewer(inputFile)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.getWordProcessingOptions().setLeftMargin(40d);
            options.getWordProcessingOptions().setRightMargin(40d);
            options.getWordProcessingOptions().setTopMargin(40d);
            options.getWordProcessingOptions().setBottomMargin(40d);

            viewer.view(options);
        }

        pageFilePathFormat = outputDirectory.resolve("html_render_margins.pdf");

        // TO PDF
        try (Viewer viewer = new Viewer(inputFile)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            options.getWordProcessingOptions().setLeftMargin(40d);
            options.getWordProcessingOptions().setRightMargin(40d);
            options.getWordProcessingOptions().setTopMargin(40d);
            options.getWordProcessingOptions().setBottomMargin(40d);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
