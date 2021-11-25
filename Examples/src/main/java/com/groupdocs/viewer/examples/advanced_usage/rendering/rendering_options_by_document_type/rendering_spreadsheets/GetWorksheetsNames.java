package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.options.SpreadsheetOptions;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ViewInfo;

/**
 * This example demonstrates how to retrieve and print worksheets names.
 */
public class GetWorksheetsNames {
    public static void run() {
        try (Viewer viewer = new Viewer(TestFiles.THREE_SHEETS)) {
            ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
            viewInfoOptions.setSpreadsheetOptions(SpreadsheetOptions.forOnePagePerSheet());

            ViewInfo viewInfo = viewer.getViewInfo(viewInfoOptions);

            System.out.println("Worksheets:");
            for (Page page : viewInfo.getPages()) {
                System.out.println(" - Worksheet " + page.getNumber() + " name '" + page.getName() + "'");
            }
        }
    }
}
