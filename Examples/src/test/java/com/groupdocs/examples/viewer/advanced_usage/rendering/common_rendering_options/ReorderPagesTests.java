package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class ReorderPagesTests {

    /**
     * This example demonstrates how to reorder pages in the output PDF document.
     */
    @Test
    public void run() {
        ReorderPages.run(SampleFiles.SAMPLE_DOCX);
    }
}