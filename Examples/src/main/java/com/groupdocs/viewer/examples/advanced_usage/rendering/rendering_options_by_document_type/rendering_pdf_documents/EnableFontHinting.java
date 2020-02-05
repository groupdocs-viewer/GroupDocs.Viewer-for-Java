package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;

import java.io.File;
import java.io.IOException;

public class EnableFontHinting {

    /**
     * This example demonstrates how to adjust the display of outline font when
     * rendering PDF documents.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("EnableFontHinting");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.png").getPath();

        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);
        viewOptions.getPdfOptions().setEnableFontHinting(true);

        Viewer viewer = new Viewer(SampleFiles.HIEROGLYPHS_1_PDF);
        viewer.view(viewOptions, 1);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}