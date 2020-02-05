package com.groupdocs.viewer.examples.basic_usage.render_document_to_html;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.IOException;

public class RenderToHtmlWithEmbeddedResources {

    /**
     * This example demonstrates how to render document into HTML with embedded
     * resources.
     */
    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderToHtmlWithEmbeddedResources");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}