package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

public class RenderOriginalPageSize {

    /**
     * This example demonstrates how to rotate first page on 90 degree clockwise.
     */
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderOriginalPageSize");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.png");

        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);
        viewOptions.getPdfOptions().setRenderOriginalPageSize(true);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PDF)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}