package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render IGS document into HTML, JPG, PNG, PDF.
 */
public class RenderingIgsTests {
    @Test
    public void run() {
        RenderingIgs.run(SampleFiles.SAMPLE_IGS);
    }
}
