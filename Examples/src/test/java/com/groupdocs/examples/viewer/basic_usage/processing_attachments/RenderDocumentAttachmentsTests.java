package com.groupdocs.examples.viewer.basic_usage.processing_attachments;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderDocumentAttachmentsTests {

    /**
     * This example demonstrates how to render attachment into HTML.
     */
    @Test
    public void run() {
        RenderDocumentAttachments.run(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS);
    }
}