package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class AddWatermarkTests {

    /**
     * This example demonstrates how to render document and add watermark to each
     * page.
     */
    @Test
    public void runTest() {
        AddWatermark.run(SampleFiles.SAMPLE_DOCX);
    }
}