package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.TextOverflowMode;

import java.io.File;
import java.io.IOException;

public class AdjustTextOverflowInCells {

    /**
     * This example demonstrates how to hide text that overflows cells.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustTextOverflowInCells");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getSpreadsheetOptions().setTextOverflowMode(TextOverflowMode.HIDE_TEXT);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_XLSX_WITH_TEXT_OVERFLOW);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}