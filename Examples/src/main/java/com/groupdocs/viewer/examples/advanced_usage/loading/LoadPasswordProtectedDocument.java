package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

import java.nio.file.Path;

public class LoadPasswordProtectedDocument {

    /**
     * This example demonstrates how to render password-protected document.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("LoadPasswordProtectedDocument");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");
        String password = "12345";

        final LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX_WITH_PASSWORD, loadOptions)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}