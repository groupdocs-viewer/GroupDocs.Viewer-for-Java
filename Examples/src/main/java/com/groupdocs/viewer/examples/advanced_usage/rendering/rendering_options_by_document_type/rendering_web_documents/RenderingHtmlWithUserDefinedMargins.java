package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Paths;

/**
 * This example demonstrates how to render HTML files with user defined margins.
 */
public class RenderingHtmlWithUserDefinedMargins {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingHtmlWithUserDefinedMargins");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "html_render_margins_page_{0}.jpg");

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
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_HTML)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            options.getWordProcessingOptions().setLeftMargin(40);
            options.getWordProcessingOptions().setRightMargin(40);
            options.getWordProcessingOptions().setTopMargin(40);
            options.getWordProcessingOptions().setBottomMargin(40);

            viewer.view(options);
        }

        pageFilePathFormat = Paths.get(outputDirectory, "html_render_margins_page_{0}.png").toString();

        // TO PNG
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_HTML)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.getWordProcessingOptions().setLeftMargin(40);
            options.getWordProcessingOptions().setRightMargin(40);
            options.getWordProcessingOptions().setTopMargin(40);
            options.getWordProcessingOptions().setBottomMargin(40);

            viewer.view(options);
        }

        pageFilePathFormat = Paths.get(outputDirectory, "html_render_margins.pdf").toString();

        // TO PDF
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_HTML)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            options.getWordProcessingOptions().setLeftMargin(40);
            options.getWordProcessingOptions().setRightMargin(40);
            options.getWordProcessingOptions().setTopMargin(40);
            options.getWordProcessingOptions().setBottomMargin(40);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
