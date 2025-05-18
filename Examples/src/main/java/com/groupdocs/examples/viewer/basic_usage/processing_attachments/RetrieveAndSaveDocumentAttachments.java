package com.groupdocs.examples.viewer.basic_usage.processing_attachments;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.results.Attachment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class RetrieveAndSaveDocumentAttachments {

    /**
     * This example demonstrates how to retrieve and save attachments.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RetrieveAndSaveDocumentAttachments");

        try (Viewer viewer = new Viewer(inputFile)) {

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