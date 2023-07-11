package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderOutlookDataFileFolder {

    /**
     * This example demonstrates how to render messages from Inbox folder of Outlook
     * data file.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderOutlookDataFileFolder");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getOutlookOptions().setFolder("Входящие");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_OST_SUBFOLDERS)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}