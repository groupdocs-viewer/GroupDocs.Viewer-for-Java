package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderDocumentWithNotes {

    /**
     * This example demonstrates how to render presentation with notes.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderDocumentWithNotes");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.setRenderNotes(true);

        try (Viewer viewer = new Viewer(TestFiles.PPTX_WITH_NOTES)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}