package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.PageSize;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.nio.file.Path;

public class AdjustPageSize {

    /**
     * This example demonstrates how to change page size when rendering email
     * messages.
     */
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("AdjustPageSize");
        Path filePath = outputDirectory.resolve("output.pdf");

        PdfViewOptions viewOptions = new PdfViewOptions(filePath);
        viewOptions.getEmailOptions().setPageSize(PageSize.A4);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}