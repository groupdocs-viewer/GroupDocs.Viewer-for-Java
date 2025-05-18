package com.groupdocs.examples.viewer.basic_usage.processing_attachments;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.caching.extra.CacheableFactory;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.results.Attachment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class RenderDocumentAttachments {

    /**
     * This example demonstrates how to render attachment into HTML.
     */
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderDocumentAttachments");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        Attachment attachment = CacheableFactory.getInstance().newAttachment("attachment-word.doc", pageFilePathFormat.toString());

        try (ByteArrayOutputStream attachmentStream = new ByteArrayOutputStream();
             Viewer viewer = new Viewer(inputFile)) {
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