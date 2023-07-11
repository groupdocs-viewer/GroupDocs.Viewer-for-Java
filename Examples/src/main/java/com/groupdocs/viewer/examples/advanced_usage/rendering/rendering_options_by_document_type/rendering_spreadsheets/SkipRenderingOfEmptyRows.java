package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class SkipRenderingOfEmptyRows {

    /**
     * This example demonstrates how to skip rendering of empty rows.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("SkipRenderingOfEmptyRows");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewInfoOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewInfoOptions.getSpreadsheetOptions().setSkipEmptyRows(true);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX_WITH_EMPTY_ROW)) {
            viewer.view(viewInfoOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}