package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.nio.file.Path;

public class EnableLayeredRendering {

    /**
     * This example demonstrates how to render PDF document and place content
     * according to Z-Index of the content in source PDF document.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("EnableLayeredRendering");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getPdfOptions().setEnableLayeredRendering(true);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_PDF)) {
            viewer.view(viewOptions, 1);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}