package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render CDR document into HTML, JPG, PNG, PDF.
 */
public class RenderingCdrTests {
    @Test
    public void run() {
        RenderingCdr.run(SampleFiles.SAMPLE_CDR);
    }
}
