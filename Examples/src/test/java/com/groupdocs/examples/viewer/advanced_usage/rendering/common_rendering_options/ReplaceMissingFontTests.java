package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class ReplaceMissingFontTests {

    /**
     * This example demonstrates how to use pre-defined font instead of missing
     * font.
     */
    @Test
    public void run() {
        ReplaceMissingFont.run(SampleFiles.MISSING_FONT_PPTX);
    }
}