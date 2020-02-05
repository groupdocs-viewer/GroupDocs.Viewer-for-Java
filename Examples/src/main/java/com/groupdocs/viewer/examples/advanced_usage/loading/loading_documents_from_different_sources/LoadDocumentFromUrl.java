package com.groupdocs.viewer.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class LoadDocumentFromUrl {

    /**
     * This example demonstrates how to download and render document.
     */

    public static void run() throws IOException {
        String url = "https://cms.admin.containerize.com/templates/groupdocs/images/logos/groupdocs-logo.png";
        String outputDirectory = Utils.getOutputDirectoryPath("LoadDocumentFromUrl");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        InputStream fileStream = new URL(url).openStream();
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        Viewer viewer = new Viewer(fileStream);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}