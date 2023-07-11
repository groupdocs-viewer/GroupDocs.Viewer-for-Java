package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class DisableCharactersGrouping {

    /**
     * This example demonstrates how to position characters with maximum precision
     * when rendering PDF documents.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("DisableCharactersGrouping");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getPdfOptions().setDisableCharsGrouping(true);

        try (Viewer viewer = new Viewer(TestFiles.HIEROGLYPHS_PDF)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}