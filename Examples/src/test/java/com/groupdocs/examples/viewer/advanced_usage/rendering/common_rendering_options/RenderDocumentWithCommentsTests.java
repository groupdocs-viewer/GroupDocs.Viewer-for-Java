package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderDocumentWithCommentsTests {

    /**
     * This example demonstrates how to render document with comments.
     */
    @Test
    public void run() {
        RenderDocumentWithComments.run(SampleFiles.SAMPLE_DOCX_WITH_COMMENT);
    }
}