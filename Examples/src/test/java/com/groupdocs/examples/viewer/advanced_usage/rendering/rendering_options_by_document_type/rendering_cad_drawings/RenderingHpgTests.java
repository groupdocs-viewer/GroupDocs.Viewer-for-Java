package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render HPG document into HTML, JPG, PNG, PDF.
 */
public class RenderingHpgTests {
    @Test
    public void run() {
        RenderingHpg.run(SampleFiles.SAMPLE_HPG);
    }
}
