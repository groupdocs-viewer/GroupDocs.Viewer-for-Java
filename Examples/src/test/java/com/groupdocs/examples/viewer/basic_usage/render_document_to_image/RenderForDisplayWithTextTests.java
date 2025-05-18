package com.groupdocs.examples.viewer.basic_usage.render_document_to_image;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderForDisplayWithTextTests {

    /**
     * This example demonstrates how to render document so extracted text may be
     * placed as top layer over the image.
     */
    @Test
    public void run() {
        RenderForDisplayWithText.run(SampleFiles.SAMPLE_DOCX);
    }
}