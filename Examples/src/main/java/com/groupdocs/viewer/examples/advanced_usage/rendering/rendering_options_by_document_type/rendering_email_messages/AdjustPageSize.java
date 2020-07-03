package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PageSize;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.io.File;
import java.io.IOException;

public class AdjustPageSize {

    /**
     * This example demonstrates how to change page size when rendering email
     * messages.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustPageSize");
        String filePath = new File(outputDirectory, "output.pdf").getPath();

        PdfViewOptions viewOptions = new PdfViewOptions(filePath);
        viewOptions.getEmailOptions().setPageSize(PageSize.A4);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_MSG);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}