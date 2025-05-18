package com.groupdocs.examples.viewer.advanced_usage.loading;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class LoadPasswordProtectedDocumentTests {

    /**
     * This example demonstrates how to render password-protected document.
     */
    @Test
    public void run() {
        LoadPasswordProtectedDocument.run(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD);
    }
}