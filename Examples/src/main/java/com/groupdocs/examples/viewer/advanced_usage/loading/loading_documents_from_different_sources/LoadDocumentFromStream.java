package com.groupdocs.examples.viewer.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class LoadDocumentFromStream {

    /**
     * This example demonstrates how to render document from stream.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("LoadDocumentFromStream");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (InputStream fileStream = new FileInputStream(inputFile.toString());
             Viewer viewer = new Viewer(fileStream)) {
            viewer.view(viewOptions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

}