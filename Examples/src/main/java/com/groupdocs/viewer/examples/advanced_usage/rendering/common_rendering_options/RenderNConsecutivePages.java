package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.nio.file.Path;

public class RenderNConsecutivePages {

    /**
     * This example demonstrates how to render range of pages.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderNConsecutivePages");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        int[] pages = new int[]{1, 2, 3};
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions, pages);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}