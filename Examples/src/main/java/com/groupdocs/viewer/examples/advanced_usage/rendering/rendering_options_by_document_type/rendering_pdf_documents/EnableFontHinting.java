package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;

import java.nio.file.Path;

public class EnableFontHinting {

    /**
     * This example demonstrates how to adjust the display of outline font when
     * rendering PDF documents.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("EnableFontHinting");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.png");

        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);
        viewOptions.getPdfOptions().setEnableFontHinting(true);

        try (Viewer viewer = new Viewer(TestFiles.HIEROGLYPHS_1_PDF)) {
            viewer.view(viewOptions, 1);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}