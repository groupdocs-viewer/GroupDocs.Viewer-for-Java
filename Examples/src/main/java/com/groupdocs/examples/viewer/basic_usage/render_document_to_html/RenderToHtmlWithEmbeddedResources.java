package com.groupdocs.examples.viewer.basic_usage.render_document_to_html;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderToHtmlWithEmbeddedResources {

    /**
     * This example demonstrates how to render document into HTML with embedded
     * resources.
     */
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderToHtmlWithEmbeddedResources");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}