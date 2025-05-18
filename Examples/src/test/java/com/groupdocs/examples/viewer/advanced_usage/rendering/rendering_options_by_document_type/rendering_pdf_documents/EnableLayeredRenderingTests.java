package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class EnableLayeredRenderingTests {

    /**
     * This example demonstrates how to render PDF document and place content
     * according to Z-Index of the content in source PDF document.
     */
    @Test
    public void run() {
        EnableLayeredRendering.run(SampleFiles.SAMPLE_PDF);
    }
}