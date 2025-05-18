package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderNConsecutivePages {

    /**
     * This example demonstrates how to render range of pages.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderNConsecutivePages");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        int[] pages = new int[]{1, 2, 3};
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions, pages);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}