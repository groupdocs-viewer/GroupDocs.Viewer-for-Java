package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to render XPS/OXPS document with embedded font
 * license restrictions.
 */
public class DisableFontLicenseVerifications {

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("DisableFontLicenseVerifications");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        try (Viewer viewer = new Viewer(TestFiles.OXPS_EMBEDDED_FONT)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.getPdfOptions().setDisableFontLicenseVerifications(true);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
