package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderOriginalPageSizeTests {

    /**
     * This example demonstrates how to rotate first page on 90 degree clockwise.
     */
    @Test
    public void run() {
        RenderOriginalPageSize.run(SampleFiles.SAMPLE_PDF);
    }
}