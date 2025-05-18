package com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to convert file to PDF and get PDF file stream.
 */
public class GetPdfStreamTests {
    @Test
    public void run() {
        GetPdfStream.run(SampleFiles.SAMPLE_DOCX);
    }
}
