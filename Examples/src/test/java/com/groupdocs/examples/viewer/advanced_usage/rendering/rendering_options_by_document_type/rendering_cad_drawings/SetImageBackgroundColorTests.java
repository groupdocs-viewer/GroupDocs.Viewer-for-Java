package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to adjust output image size when rendering CAD drawings.
 */
public class SetImageBackgroundColorTests {
    @Test
    public void run() {
        SetImageBackgroundColor.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
    }
}
