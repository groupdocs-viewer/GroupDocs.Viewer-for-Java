package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class ReplaceMissingFont {

    /**
     * This example demonstrates how to use pre-defined font instead of missing
     * font.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("ReplaceMissingFont");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.setDefaultFontName("Courier New");

        try (Viewer viewer = new Viewer(TestFiles.MISSING_FONT_PPTX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}