package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderSelectedPagesTests {

    /**
     * This example demonstrates how to render first and third pages.
     */
    @Test
    public void run() {
        RenderSelectedPages.run(SampleFiles.SAMPLE_DOCX);
    }
}