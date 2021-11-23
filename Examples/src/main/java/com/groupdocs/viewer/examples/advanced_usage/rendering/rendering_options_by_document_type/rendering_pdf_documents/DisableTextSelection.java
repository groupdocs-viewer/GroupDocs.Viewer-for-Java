package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

/**
 * This example demonstrates how to disable text selection when rendering PDF documents to HTML.
 */
public class DisableTextSelection {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("DisableTextSelection");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.html");

        try (Viewer viewer = new Viewer(TestFiles.ONE_PAGE_TEXT_PDF)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.getPdfOptions().setRenderTextAsImage(true);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
