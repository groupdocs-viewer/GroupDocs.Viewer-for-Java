package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class AdjustImageQualityTests {

    /**
     * This example demonstrates how to adjust quality of images contained by the
     * source PDF document.
     */
    @Test
    public void run() {
        AdjustImageQuality.run(SampleFiles.SAMPLE_PDF);
    }
}