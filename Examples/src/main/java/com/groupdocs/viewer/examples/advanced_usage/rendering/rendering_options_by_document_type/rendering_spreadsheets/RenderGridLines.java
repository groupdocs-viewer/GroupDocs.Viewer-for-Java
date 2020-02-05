package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.IOException;

public class RenderGridLines {

    /**
     * This example demonstrates how to render grid lines.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderGridLines");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getSpreadsheetOptions().setRenderGridLines(true);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_XLSX);
        viewer.view(viewOptions, 1, 2, 3);
        viewer.close();

        System.out.println(String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}