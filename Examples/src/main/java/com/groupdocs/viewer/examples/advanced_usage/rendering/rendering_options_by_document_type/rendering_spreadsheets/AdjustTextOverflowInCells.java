package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.TextOverflowMode;

import java.io.File;

public class AdjustTextOverflowInCells {

    /**
     * This example demonstrates how to hide text that overflows cells.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustTextOverflowInCells");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getSpreadsheetOptions().setTextOverflowMode(TextOverflowMode.HIDE_TEXT);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX_WITH_TEXT_OVERFLOW)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}