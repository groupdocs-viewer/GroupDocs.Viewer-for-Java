package com.groupdocs.examples.viewer.basic_usage.render_document_to_image;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderToPngTests {

    /**
     * This example demonstrates how to render document into PNG image.
     */
    @Test
    public void run() {
        RenderToPng.run(SampleFiles.SAMPLE_DOCX);
    }
}