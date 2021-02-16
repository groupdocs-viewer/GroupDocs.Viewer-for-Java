package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class RenderSingleLayout {

    /**
     * This example demonstrates how to render specific layout.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderSingleLayout");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getCadOptions().setLayoutName("Model");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}