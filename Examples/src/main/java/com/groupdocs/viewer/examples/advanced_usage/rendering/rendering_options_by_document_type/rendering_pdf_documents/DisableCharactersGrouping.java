package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class DisableCharactersGrouping {

    /**
     * This example demonstrates how to position characters with maximum precision
     * when rendering PDF documents.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("DisableCharactersGrouping");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getPdfOptions().setDisableCharsGrouping(true);

        try (Viewer viewer = new Viewer(SampleFiles.HIEROGLYPHS_PDF)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}