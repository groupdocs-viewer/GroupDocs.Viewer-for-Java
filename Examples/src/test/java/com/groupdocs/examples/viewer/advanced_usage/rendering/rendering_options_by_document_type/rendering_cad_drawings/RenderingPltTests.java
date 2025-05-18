package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render PLT document into HTML, JPG, PNG, PDF.
 */
public class RenderingPltTests {
    @Test
    public void run() {
        RenderingPlt.run(SampleFiles.SAMPLE_PLT);
    }
}
