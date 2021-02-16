package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

public class LoadPasswordProtectedDocument {

    /**
     * This example demonstrates how to render password-protected document.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("LoadPasswordProtectedDocument");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "page_{0}.html");
        String password = "12345";

        final LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD, loadOptions)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}