package com.groupdocs.viewer.examples.basic_usage.processing_attachments;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.results.Attachment;

import java.io.FileNotFoundException;
import java.util.List;

public class RetrieveAndPrintDocumentAttachments {

    /**
     * This example demonstrates how to retrieve and print all attachments.
     */

    public static void run() throws FileNotFoundException {
        Viewer viewer = new Viewer(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS);
        List<Attachment> attachments = viewer.getAttachments();
        viewer.close();

        System.out.println("\nAttachments:");
        for (Attachment attachment : attachments) {
            System.out.println(attachment);
        }

        System.out.println("\nAttachments retrieved successfully.");
    }
}