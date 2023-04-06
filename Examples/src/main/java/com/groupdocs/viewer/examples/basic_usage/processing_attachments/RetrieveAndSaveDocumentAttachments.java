package com.groupdocs.viewer.examples.basic_usage.processing_attachments;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.results.Attachment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class RetrieveAndSaveDocumentAttachments {

    /**
     * This example demonstrates how to retrieve and save attachments.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RetrieveAndSaveDocumentAttachments");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MSG_WITH_ATTACHMENTS)) {

            List<Attachment> attachments = viewer.getAttachments();
            for (Attachment attachment : attachments) {
                final Path file = outputDirectory.resolve(attachment.getFileName());
                try (FileOutputStream outputStream = new FileOutputStream(file.toFile())) {
                    viewer.saveAttachment(attachment, outputStream);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nAttachments saved successfully.\nCheck output in " + outputDirectory);
    }
}