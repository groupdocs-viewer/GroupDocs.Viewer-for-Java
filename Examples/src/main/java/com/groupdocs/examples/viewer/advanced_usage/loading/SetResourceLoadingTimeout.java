package com.groupdocs.examples.viewer.advanced_usage.loading;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

import java.nio.file.Path;

/**
 * This example demonstrates how to set timeout for loading external resources contained by a document.
 */
public class SetResourceLoadingTimeout {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("SetResourceLoadingTimeout");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setResourceLoadingTimeout(60_000);

        try (Viewer viewer = new Viewer(inputFile, loadOptions)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
