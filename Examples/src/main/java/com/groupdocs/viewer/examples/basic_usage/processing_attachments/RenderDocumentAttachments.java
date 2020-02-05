package com.groupdocs.viewer.examples.basic_usage.processing_attachments;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

import org.apache.commons.io.FilenameUtils;

public class RenderDocumentAttachments {

    /**
     * This example demonstrates how to render attachment into HTML.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderDocumentAttachments");

        String filePath = SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS;
        String attachmentName = "attachment-word.doc";

        ByteArrayInputStream attachmentStream = readAttachment(filePath, attachmentName);
        renderAttachment(attachmentName, attachmentStream, outputDirectory);
        attachmentStream.close();

        System.out.println("\nAttachments rendered successfully.\nCheck output in " + outputDirectory);
    }

    private static void renderAttachment(String attachmentName, ByteArrayInputStream attachmentStream, String outputDirectory)
            throws IOException {
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        String extension = "." + FilenameUtils.getExtension(attachmentName);
        FileType fileType = FileType.fromExtension(extension);
        LoadOptions loadOptions = new LoadOptions(fileType);
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        
        Viewer viewer = new Viewer(attachmentStream, loadOptions);
        viewer.view(viewOptions);
        viewer.close();
    }

    private static ByteArrayInputStream readAttachment(String filePath, String attachmentName) throws IOException {
        ByteArrayOutputStream attachmentStream = new ByteArrayOutputStream();

        try {
            Viewer viewer = new Viewer(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS);
            viewer.saveAttachment(attachmentName, attachmentStream);
            viewer.close();

            return new ByteArrayInputStream(attachmentStream.toByteArray());
        } finally {
            attachmentStream.close();
        }
    }
}