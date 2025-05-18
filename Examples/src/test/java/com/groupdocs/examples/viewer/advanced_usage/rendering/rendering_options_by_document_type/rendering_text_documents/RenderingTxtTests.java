package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_text_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render TXT document into HTML, JPG, PNG, PDF.
 */
public class RenderingTxtTests {
    @Test
    public void run() {
        RenderingTxt.run(SampleFiles.SAMPLE_TXT);
    }
}
