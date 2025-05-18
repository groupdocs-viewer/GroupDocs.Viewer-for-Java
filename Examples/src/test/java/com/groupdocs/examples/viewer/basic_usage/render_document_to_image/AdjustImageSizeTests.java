package com.groupdocs.examples.viewer.basic_usage.render_document_to_image;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class AdjustImageSizeTests {

    /**
     * This example demonstrates how to adjust size width and height of the output
     * images.
     */
    @Test
    public void run() {
        AdjustImageSize.run(SampleFiles.SAMPLE_DOCX);
    }
}