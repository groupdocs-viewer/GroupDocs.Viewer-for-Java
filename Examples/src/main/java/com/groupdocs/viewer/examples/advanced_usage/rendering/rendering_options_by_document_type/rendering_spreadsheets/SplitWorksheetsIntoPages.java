package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.SpreadsheetOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to split worksheet(s) into page(s).
 */
public class SplitWorksheetsIntoPages {

    public static void splitByRows() {

        Path outputDirectory = Utils.getOutputDirectoryPath("SplitByRows");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        try (Viewer viewer = new Viewer(TestFiles.TWO_PAGES_XLSX)) {
            int countRowsPerPage = 15;

            HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            viewOptions.setSpreadsheetOptions(SpreadsheetOptions.forSplitSheetIntoPages(countRowsPerPage));

            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    public static void splitByRowsAndColumns() {

        Path outputDirectory = Utils.getOutputDirectoryPath("SplitByRowsAndColumns");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        try (Viewer viewer = new Viewer(TestFiles.FOUR_PAGES_XLSX)) {
            int countRowsPerPage = 15;
            int countColumnsPerPage = 7;

            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.setSpreadsheetOptions(SpreadsheetOptions.forSplitSheetIntoPages(countRowsPerPage, countColumnsPerPage));

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}