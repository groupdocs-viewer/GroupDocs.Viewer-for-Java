package com.groupdocs.viewer.examples.basic_usage.processing_attachments;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.results.Attachment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RenderDocumentAttachments {

    /**
     * This example demonstrates how to render attachment into HTML.
     */
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderDocumentAttachments");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "page_{0}.html");

        Attachment attachment = CacheableFactory.getInstance().newAttachment("attachment-word.doc", pageFilePathFormat);

        try (ByteArrayOutputStream attachmentStream = new ByteArrayOutputStream();
             Viewer viewer = new Viewer(TestFiles.SAMPLE_MSG_WITH_ATTACHMENTS)) {
            viewer.saveAttachment(attachment, attachmentStream);

            try (InputStream inputStream = new ByteArrayInputStream(attachmentStream.toByteArray());
                 Viewer attachmentViewer = new Viewer(inputStream)) {
                HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

                attachmentViewer.view(options);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nAttachment rendered successfully.\nCheck output in " + outputDirectory);
    }
}