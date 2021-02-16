package com.groupdocs.viewer.examples.basic_usage.render_document_to_html;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class RenderToResponsiveHtml {

    /**
     * This example demonstrates how to render document into responsive HTML.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderToResponsiveHtml");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.setRenderResponsive(true);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}