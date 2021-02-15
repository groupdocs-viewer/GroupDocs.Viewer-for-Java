package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.CadOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

import java.awt.*;
import java.io.IOException;

/**
 * This example demonstrates how to adjust output image size when rendering CAD drawings.
 */
public class SetImageBackgroundColor {
    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("SetImageBackgroundColor");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.png");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            options.setCadOptions(CadOptions.forRenderingByWidth(800));
            options.getCadOptions().setBackgroundColor(Color.GREEN);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
