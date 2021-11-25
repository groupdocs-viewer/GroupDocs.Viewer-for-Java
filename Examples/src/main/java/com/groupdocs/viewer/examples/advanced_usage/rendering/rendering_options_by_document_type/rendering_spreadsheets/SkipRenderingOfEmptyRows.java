package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class SkipRenderingOfEmptyRows {

    /**
     * This example demonstrates how to skip rendering of empty rows.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("SkipRenderingOfEmptyRows");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewInfoOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewInfoOptions.getSpreadsheetOptions().setSkipEmptyRows(true);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_XLSX_WITH_EMPTY_ROW)) {
            viewer.view(viewInfoOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}