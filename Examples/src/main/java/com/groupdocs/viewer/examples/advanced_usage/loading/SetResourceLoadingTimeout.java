package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;
import com.groupdocs.viewer.utils.PathUtils;

/**
 * This example demonstrates how to set timeout for loading external resources contained by a document.
 */
public class SetResourceLoadingTimeout {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("SetResourceLoadingTimeout");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.html");

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setResourceLoadingTimeout(5000);

        try (Viewer viewer = new Viewer(TestFiles.WITH_EXTERNAL_IMAGE_DOC, loadOptions)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory + ".");
    }
}
