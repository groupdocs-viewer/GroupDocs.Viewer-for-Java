package com.groupdocs.examples.viewer.basic_usage.render_document_to_html;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class ExcludingFontsFromOutputHtmlTests {

    /**
     * This example demonstrates how to exclude Arial font from the output when
     * rendering into HTML.
     */
    @Test
    public void run() {
        ExcludingFontsFromOutputHtml.run(SampleFiles.SAMPLE_DOCX);
    }
}