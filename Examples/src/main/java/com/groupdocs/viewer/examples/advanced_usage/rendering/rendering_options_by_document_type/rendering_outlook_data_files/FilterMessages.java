package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class FilterMessages {

    /**
     * This example demonstrates how to filter messages by text/sender/recipient
     * when rendering Outlook data files.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("FilterMessages");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getOutlookOptions().setTextFilter("Microsoft");
        viewOptions.getOutlookOptions().setAddressFilter("susan");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_OST_SUBFOLDERS)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}