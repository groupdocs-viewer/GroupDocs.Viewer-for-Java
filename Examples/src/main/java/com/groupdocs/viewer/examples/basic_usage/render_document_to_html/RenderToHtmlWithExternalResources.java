package com.groupdocs.viewer.examples.basic_usage.render_document_to_html;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderToHtmlWithExternalResources {

    /**
     * This example demonstrates how to render document into HTML with external
     * resources.
     */
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderToHtmlWithExternalResources");

        // The {0} and {1} patterns will be replaced with current processing page number
        // and resource name accordingly.
        String pageFilePathFormat = outputDirectory + "/page_{0}.html";
        String resourceFilePathFormat = outputDirectory + "/page_{0}_{1}";
        String resourceUrlFormat = outputDirectory + "/page_{0}_{1}";

        HtmlViewOptions viewOptions = HtmlViewOptions.forExternalResources(pageFilePathFormat, resourceFilePathFormat,
                resourceUrlFormat);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}