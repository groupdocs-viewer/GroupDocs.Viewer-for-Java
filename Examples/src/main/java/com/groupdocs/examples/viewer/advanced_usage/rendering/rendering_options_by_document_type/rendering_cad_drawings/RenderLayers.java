package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.results.Layer;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RenderLayers {

    /**
     * This example demonstrates how to render layers.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderLayers");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        List<Layer> layers = new ArrayList<>();
        layers.add(CacheableFactory.getInstance().newLayer("QUADRANT"));
        viewOptions.getCadOptions().setLayers(layers);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}