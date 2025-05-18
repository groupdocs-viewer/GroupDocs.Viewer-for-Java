package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render PLT document into HTML, JPG, PNG, PDF.
 */
public class RenderingPlt {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingPlt");
        Path pageFilePathFormat = outputDirectory.resolve("plt_result.html");

        // TO HTML
        try (Viewer viewer = new Viewer(inputFile)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            //options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
            //options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400,400)); // Render image and set output size to 400x400
            //options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
            //options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = outputDirectory.resolve("plt_result.jpg");

        try (Viewer viewer = new Viewer(inputFile)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            //options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
            //options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400,400)); // Render image and set output size to 400x400
            //options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
            //options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = outputDirectory.resolve("plt_result.png");

        try (Viewer viewer = new Viewer(inputFile)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            //options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
            //options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400,400)); // Render image and set output size to 400x400
            //options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
            //options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = outputDirectory.resolve("plt_result.pdf");

        try (Viewer viewer = new Viewer(inputFile)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            //options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
            //options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400,400)); // Render image and set output size to 400x400
            //options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
            //options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
