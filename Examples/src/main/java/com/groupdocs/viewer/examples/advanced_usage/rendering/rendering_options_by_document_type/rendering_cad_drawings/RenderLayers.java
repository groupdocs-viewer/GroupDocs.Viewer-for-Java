package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.results.Layer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RenderLayers {

    /**
     * This example demonstrates how to render layers.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderLayers");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        List<Layer> layers = new ArrayList<>();
        layers.add(CacheableFactory.getInstance().newLayer("QUADRANT"));
        viewOptions.getCadOptions().setLayers(layers);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS)) {
            viewer.view(viewOptions);
        }

        System.out.println(String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}