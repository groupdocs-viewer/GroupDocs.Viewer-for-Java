package com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderToPdfTests {

    /**
     * This example demonstrates how to render document into PDF file.
     */
    @Test
    public void run() {
        RenderToPdf.run(SampleFiles.SAMPLE_DOCX);
    }
}