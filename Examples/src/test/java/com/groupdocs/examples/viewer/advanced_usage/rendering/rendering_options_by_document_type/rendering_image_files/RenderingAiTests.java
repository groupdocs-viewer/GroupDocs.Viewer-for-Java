package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render Ai document into HTML, JPG, PNG, PDF.
 */
public class RenderingAiTests {
    @Test
    public void run() {
        RenderingAi.run(SampleFiles.SAMPLE_AI);
    }
}
