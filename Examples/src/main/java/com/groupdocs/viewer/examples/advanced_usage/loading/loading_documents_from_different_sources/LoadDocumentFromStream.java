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

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("LoadDocumentFromStream");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        InputStream fileStream = new FileInputStream(SampleFiles.SAMPLE_DOCX);
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        Viewer viewer = new Viewer(fileStream);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }

}