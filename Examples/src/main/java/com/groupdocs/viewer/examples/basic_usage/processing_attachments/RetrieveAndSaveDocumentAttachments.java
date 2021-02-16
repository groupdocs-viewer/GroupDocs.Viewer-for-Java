package com.groupdocs.viewer.examples.basic_usage.processing_attachments;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.results.Attachment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class RetrieveAndSaveDocumentAttachments {

    /**
     * This example demonstrates how to retrieve and save attachments.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RetrieveAndSaveDocumentAttachments");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS)) {

            List<Attachment> attachments = viewer.getAttachments();
            for (Attachment attachment : attachments) {
                final File file = new File(Utils.combinePaths(outputDirectory, attachment.getFileName()));
                try (FileOutputStream outputStream = new FileOutputStream(file)) {
                    viewer.saveAttachment(attachment, outputStream);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nAttachments saved successfully.\nCheck output in " + outputDirectory);
    }
}