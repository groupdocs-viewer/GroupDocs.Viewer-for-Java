package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.Watermark;

import java.io.File;
import java.nio.file.Path;

public class AddWatermark {

    /**
     * This example demonstrates how to render document and add watermark to each
     * page.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("AddWatermark");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.setWatermark(new Watermark("This is a watermark"));

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}