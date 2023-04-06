package com.groupdocs.viewer.examples.basic_usage.render_document_to_html;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.nio.file.Path;

public class ExcludingFontsFromOutputHtml {

    /**
     * This example demonstrates how to exclude Arial font from the output when
     * rendering into HTML.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("ExcludingFontsFromOutputHtml");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getFontsToExclude().add("Arial");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}