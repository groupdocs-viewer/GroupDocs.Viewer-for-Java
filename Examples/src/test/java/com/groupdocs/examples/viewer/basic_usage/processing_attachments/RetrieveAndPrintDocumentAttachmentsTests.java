package com.groupdocs.examples.viewer.basic_usage.processing_attachments;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RetrieveAndPrintDocumentAttachmentsTests {

    /**
     * This example demonstrates how to retrieve and print all attachments.
     */
    @Test
    public void run() {
        RetrieveAndPrintDocumentAttachments.run(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS);
    }
}