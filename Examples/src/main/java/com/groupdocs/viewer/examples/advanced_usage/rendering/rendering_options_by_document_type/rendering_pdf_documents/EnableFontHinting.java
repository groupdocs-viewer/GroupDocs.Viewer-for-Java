package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;

import java.io.File;

public class EnableFontHinting {

    /**
     * This example demonstrates how to adjust the display of outline font when
     * rendering PDF documents.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("EnableFontHinting");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.png").getPath();

        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);
        viewOptions.getPdfOptions().setEnableFontHinting(true);

        try (Viewer viewer = new Viewer(TestFiles.HIEROGLYPHS_1_PDF)) {
            viewer.view(viewOptions, 1);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}