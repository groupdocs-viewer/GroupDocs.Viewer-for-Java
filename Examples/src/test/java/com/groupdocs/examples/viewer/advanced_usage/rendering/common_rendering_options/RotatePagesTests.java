package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RotatePagesTests {

    /**
     * This example demonstrates how to rotate first page on 90 degree clockwise.
     */
    @Test
    public void run() {
        RotatePages.run(SampleFiles.SAMPLE_PDF);
    }
}