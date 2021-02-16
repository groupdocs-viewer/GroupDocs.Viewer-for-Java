package com.groupdocs.viewer.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoadDocumentFromStream {

    /**
     * This example demonstrates how to render document from stream.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("LoadDocumentFromStream");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (InputStream fileStream = new FileInputStream(SampleFiles.SAMPLE_DOCX);
             Viewer viewer = new Viewer(fileStream)) {
            viewer.view(viewOptions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

}