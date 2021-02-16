package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class RenderGridLines {

    /**
     * This example demonstrates how to render grid lines.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderGridLines");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getSpreadsheetOptions().setRenderGridLines(true);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_XLSX)) {
            viewer.view(viewOptions, 1, 2, 3);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}