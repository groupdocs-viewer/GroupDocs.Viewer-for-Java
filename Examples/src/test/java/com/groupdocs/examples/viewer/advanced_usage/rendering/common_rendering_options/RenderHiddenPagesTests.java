package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderHiddenPagesTests {

    /**
     * This example demonstrates how to enable rendering of the hidden pages.
     */
    @Test
    public void run() {
        RenderHiddenPages.run(SampleFiles.SAMPLE_PPTX_HIDDEN_PAGE);
    }
}