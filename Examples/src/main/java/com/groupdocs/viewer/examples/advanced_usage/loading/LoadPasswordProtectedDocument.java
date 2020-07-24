package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;
import com.groupdocs.viewer.utils.PathUtils;

import java.io.IOException;

public class LoadPasswordProtectedDocument {

    /**
     * This example demonstrates how to render password-protected document.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("LoadPasswordProtectedDocument");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.html");
        String password = "12345";

        final LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD, loadOptions);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}