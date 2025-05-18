package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class EnableFontHintingTests {

    /**
     * This example demonstrates how to adjust the display of outline font when
     * rendering PDF documents.
     */
    @Test
    public void run() {
        EnableFontHinting.run(SampleFiles.HIEROGLYPHS_1_PDF);
    }
}