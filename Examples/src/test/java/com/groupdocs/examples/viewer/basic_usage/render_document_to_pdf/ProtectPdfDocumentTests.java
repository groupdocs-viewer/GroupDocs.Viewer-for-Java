package com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class ProtectPdfDocumentTests {

    /**
     * This example demonstrates how to protect output PDF document.
     */
    @Test
    public void run() {
        ProtectPdfDocument.run(SampleFiles.SAMPLE_DOCX);
    }
}