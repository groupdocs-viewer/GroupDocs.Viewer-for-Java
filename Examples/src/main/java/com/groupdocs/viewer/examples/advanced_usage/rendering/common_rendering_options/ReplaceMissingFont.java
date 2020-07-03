package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.IOException;

public class ReplaceMissingFont {

    /**
     * This example demonstrates how to use pre-defined font instead of missing
     * font.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("ReplaceMissingFont");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.setDefaultFontName("Courier New");

        Viewer viewer = new Viewer(SampleFiles.MISSING_FONT_PPTX);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}