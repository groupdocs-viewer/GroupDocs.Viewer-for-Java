package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.CadOptions;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.IOException;

public class AdjustOutputImageSize {

    /**
     * This example demonstrates how to adjust output image size when rendering CAD
     * drawings.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustOutputImageSize");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.setCadOptions(CadOptions.forRenderingByScaleFactor(0.5f));

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}