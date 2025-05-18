package com.groupdocs.examples.viewer.basic_usage.render_document_to_html;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class MinifyHtmlDocumentTests {

    /**
     * This example demonstrates how to enable minification of HTML document.
     */
    @Test
    public void run() {
        MinifyHtmlDocument.run(SampleFiles.SAMPLE_DOCX);
    }
}