package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class RenderHiddenRowsAndColumns {

    /**
     * This example demonstrates how to render hidden rows and columns.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderHiddenRowsAndColumns");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getSpreadsheetOptions().setRenderHiddenColumns(true);
        viewOptions.getSpreadsheetOptions().setRenderHiddenRows(true);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX_WITH_HIDDEN_ROW_AND_COLUMN)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}