package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to rotate the first page 90-degree clockwise.
 */
public class FlipRotatePagesTests {
    @Test
    public void run() {
        FlipRotatePages.run(SampleFiles.SAMPLE_DOCX);
    }
}
