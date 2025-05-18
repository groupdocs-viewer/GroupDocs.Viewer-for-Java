package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderLayersTests {

    /**
     * This example demonstrates how to render layers.
     */

    @Test
    public void run() {
        RenderLayers.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
    }
}