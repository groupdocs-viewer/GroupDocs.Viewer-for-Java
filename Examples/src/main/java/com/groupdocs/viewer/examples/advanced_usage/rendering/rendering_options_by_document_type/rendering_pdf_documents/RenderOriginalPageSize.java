package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;

import java.io.File;
import java.io.IOException;

public class RenderOriginalPageSize {

    /**
     * This example demonstrates how to rotate first page on 90 degree clockwise.
     */
    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderOriginalPageSize");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.png").getPath();

        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);
        viewOptions.getPdfOptions().setRenderOriginalPageSize(true);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_PDF)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}