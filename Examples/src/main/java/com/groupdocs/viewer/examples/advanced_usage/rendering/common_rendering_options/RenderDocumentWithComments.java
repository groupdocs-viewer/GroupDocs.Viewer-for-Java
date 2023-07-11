package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderDocumentWithComments {

    /**
     * This example demonstrates how to render document with comments.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderDocumentWithComments");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.setRenderComments(true);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX_WITH_COMMENT)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}