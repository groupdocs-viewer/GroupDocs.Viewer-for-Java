package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render FODG/ODG document into HTML, JPG, PNG, PDF.
 */
public class RenderingFodgAndOdgTests {
    @Test
    public void run() {
        RenderingFodgAndOdg.run(SampleFiles.SAMPLE_FODG);
    }
}
