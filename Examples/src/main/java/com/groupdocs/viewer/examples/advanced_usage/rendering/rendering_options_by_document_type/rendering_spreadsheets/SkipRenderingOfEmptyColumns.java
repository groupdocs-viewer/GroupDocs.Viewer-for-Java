package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class SkipRenderingOfEmptyColumns {

    /**
     * This example demonstrates how to skip rendering of empty columns.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("SkipRenderingOfEmptyColumns");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getSpreadsheetOptions().setSkipEmptyColumns(true);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX_WITH_EMPTY_COLUMN)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}