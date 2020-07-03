package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.SpreadsheetOptions;

import java.io.File;
import java.io.IOException;

public class SplitWorksheetsIntoPages {

    /**
     * This example demonstrates how to split worksheet(s) into page(s).
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("SplitWorksheetsIntoPages");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        int countRowsPerPage = 45;
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.setSpreadsheetOptions(SpreadsheetOptions.forSplitSheetIntoPages(countRowsPerPage));

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_XLSX);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}