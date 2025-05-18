package com.groupdocs.examples.viewer.basic_usage.render_document_to_html;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderToHtmlWithExternalResources {

    /**
     * This example demonstrates how to render document into HTML with external
     * resources.
     */
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderToHtmlWithExternalResources");

        // The {0} and {1} patterns will be replaced with current processing page number
        // and resource name accordingly.
        String pageFilePathFormat = outputDirectory + "/page_{0}.html";
        String resourceFilePathFormat = outputDirectory + "/page_{0}_{1}";
        String resourceUrlFormat = outputDirectory + "/page_{0}_{1}";

        HtmlViewOptions viewOptions = HtmlViewOptions.forExternalResources(pageFilePathFormat, resourceFilePathFormat,
                resourceUrlFormat);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}