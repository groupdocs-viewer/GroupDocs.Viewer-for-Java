package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_presentation_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render FODP document into HTML, JPG, PNG, PDF.
 */
public class RenderingFodpTests {
    @Test
    public void run() {
        RenderingFodp.run(SampleFiles.SAMPLE_FODP);
    }
}
