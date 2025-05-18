package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how set output image size limits when rendering documents to JPG/PNG.
 */
public class SetImageSizeLimitsTests {
    @Test
    public void run() {
        SetImageSizeLimits.run(SampleFiles.SAMPLE_CF2);
    }
}
