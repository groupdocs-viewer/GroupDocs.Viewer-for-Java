package com.groupdocs.examples.viewer.basic_usage.render_document_to_image;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderToJpgTests {

    /**
     * This example demonstrates how to render document into JPG image.
     */
    @Test
    public void run() {
        RenderToJpg.run(SampleFiles.SAMPLE_DOCX);
    }
}