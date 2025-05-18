package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class DisableCharactersGroupingTests {

    /**
     * This example demonstrates how to position characters with maximum precision
     * when rendering PDF documents.
     */
    @Test
    public void run() {
        DisableCharactersGrouping.run(SampleFiles.HIEROGLYPHS_PDF);
    }
}