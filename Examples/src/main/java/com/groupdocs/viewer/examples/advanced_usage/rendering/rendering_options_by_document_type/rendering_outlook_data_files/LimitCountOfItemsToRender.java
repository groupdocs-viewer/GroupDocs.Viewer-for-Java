package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.IOException;

public class LimitCountOfItemsToRender {

    /**
     * This example demonstrates how to limit count of items when rendering Outlook
     * data files.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("LimitCountOfItemsToRender");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getOutlookOptions().setMaxItemsInFolder(3);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_OST)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}