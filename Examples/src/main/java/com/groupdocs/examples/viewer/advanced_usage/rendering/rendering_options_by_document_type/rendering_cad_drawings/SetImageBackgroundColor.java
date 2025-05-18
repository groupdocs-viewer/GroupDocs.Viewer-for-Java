package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.CadOptions;
import com.groupdocs.viewer.options.PngViewOptions;

import java.awt.*;
import java.nio.file.Path;

/**
 * This example demonstrates how to adjust output image size when rendering CAD drawings.
 */
public class SetImageBackgroundColor {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("SetImageBackgroundColor");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.png");

        try (Viewer viewer = new Viewer(inputFile)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.setCadOptions(CadOptions.forRenderingByWidth(800));
            options.getCadOptions().setBackgroundColor(Color.GREEN);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
