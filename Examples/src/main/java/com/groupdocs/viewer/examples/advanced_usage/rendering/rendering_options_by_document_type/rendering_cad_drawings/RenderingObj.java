package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render OBJ document into HTML, JPG, PNG, PDF.
 */
public class RenderingObj {
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.html");

        // TO HTML
        runToHtml(pageFilePathFormat);

        // TO JPG
        runToJpg(outputDirectory);

        // TO PNG
        runToPng(outputDirectory);

        // TO PDF
        runToPdf(outputDirectory);

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    public static void runToHtml(Path pageFilePathFormat) {
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_OBJ)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
//            options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
            //options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400,400)); // Render image and set output size to 400x400
            //options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
            //options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

            viewer.view(options);
        }
    }

    public static void runToJpg(Path outputDirectory) {
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_OBJ)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);
            //options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
            //options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400,400)); // Render image and set output size to 400x400
            //options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
            //options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

            viewer.view(options);
        }
    }

    public static void runToPng(Path outputDirectory) {
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_OBJ)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            //options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
            //options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400,400)); // Render image and set output size to 400x400
            //options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
            //options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

            viewer.view(options);
        }
    }

    public static void runToPdf(Path outputDirectory) {
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_OBJ)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);
            //options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
            //options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400,400)); // Render image and set output size to 400x400
            //options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
            //options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

            viewer.view(options);
        }
    }
}
