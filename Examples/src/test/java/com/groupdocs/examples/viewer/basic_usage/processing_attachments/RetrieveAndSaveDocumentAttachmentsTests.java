package com.groupdocs.examples.viewer.basic_usage.processing_attachments;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RetrieveAndSaveDocumentAttachmentsTests {

    /**
     * This example demonstrates how to retrieve and save attachments.
     */
    @Test
    public void run() {
        RetrieveAndSaveDocumentAttachments.run(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS);
    }
}