package com.groupdocs.examples.viewer.advanced_usage.loading;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

import java.nio.charset.Charset;
import java.nio.file.Path;

/**
 * This example demonstrates how to specify encoding.
 */
public class LoadDocumentsWithEncoding {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("LoadDocumentsWithEncoding");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setCharset(Charset.forName("shift_jis"));

        try (Viewer viewer = new Viewer(inputFile, loadOptions)) {
            HtmlViewOptions options =
                    HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
