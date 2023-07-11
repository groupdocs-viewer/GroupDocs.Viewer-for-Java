package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderGridLines {

    /**
     * This example demonstrates how to render grid lines.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderGridLines");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getSpreadsheetOptions().setRenderGridLines(true);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX)) {
            viewer.view(viewOptions, 1, 2, 3);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}