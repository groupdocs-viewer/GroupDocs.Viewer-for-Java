package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PageSize;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.nio.file.Path;

public class AdjustPageSize {

    /**
     * This example demonstrates how to change page size when rendering email
     * messages.
     */
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("AdjustPageSize");
        Path filePath = outputDirectory.resolve("output.pdf");

        PdfViewOptions viewOptions = new PdfViewOptions(filePath);
        viewOptions.getEmailOptions().setPageSize(PageSize.A4);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MSG)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}