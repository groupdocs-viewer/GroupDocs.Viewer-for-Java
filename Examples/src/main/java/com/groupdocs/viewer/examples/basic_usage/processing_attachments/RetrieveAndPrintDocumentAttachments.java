package com.groupdocs.viewer.examples.basic_usage.processing_attachments;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.results.Attachment;

import java.util.List;

public class RetrieveAndPrintDocumentAttachments {

    /**
     * This example demonstrates how to retrieve and print all attachments.
     */

    public static void run() {
        List<Attachment> attachments;
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS)) {
            attachments = viewer.getAttachments();
        }

        System.out.println("\nAttachments:");
        for (Attachment attachment : attachments) {
            System.out.println(attachment);
        }

        System.out.println("\nAttachments retrieved successfully.");
    }
}