package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render CMX document into HTML, JPG, PNG, PDF.
 */
public class RenderingCmxTests {
    @Test
    public void run() {
        RenderingCmx.run(SampleFiles.SAMPLE_CMX);
    }
}
