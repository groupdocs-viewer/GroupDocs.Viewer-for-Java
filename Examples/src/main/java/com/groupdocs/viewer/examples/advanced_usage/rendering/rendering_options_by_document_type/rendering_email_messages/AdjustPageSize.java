package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PageSize;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.io.File;

public class AdjustPageSize {

    /**
     * This example demonstrates how to change page size when rendering email
     * messages.
     */
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustPageSize");
        String filePath = new File(outputDirectory, "output.pdf").getPath();

        PdfViewOptions viewOptions = new PdfViewOptions(filePath);
        viewOptions.getEmailOptions().setPageSize(PageSize.A4);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MSG)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}