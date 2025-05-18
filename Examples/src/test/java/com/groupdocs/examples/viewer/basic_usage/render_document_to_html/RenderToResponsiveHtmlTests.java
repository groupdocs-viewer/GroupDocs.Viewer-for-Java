package com.groupdocs.examples.viewer.basic_usage.render_document_to_html;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderToResponsiveHtmlTests {

    /**
     * This example demonstrates how to render document into responsive HTML.
     */
    @Test
    public void run() {
        RenderToResponsiveHtml.run(SampleFiles.SAMPLE_DOCX);
    }
}