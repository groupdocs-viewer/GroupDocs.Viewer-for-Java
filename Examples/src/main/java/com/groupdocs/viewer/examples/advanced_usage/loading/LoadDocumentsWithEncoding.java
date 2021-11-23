package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;
import com.groupdocs.viewer.utils.PathUtils;

import java.nio.charset.Charset;

/**
 * This example demonstrates how to specify encoding.
 */
public class LoadDocumentsWithEncoding {
    public static void run() {
        String filePath = TestFiles.SAMPLE_TXT_SHIFT_JS_ENCODED;
        String outputDirectory = Utils.getOutputDirectoryPath("LoadDocumentsWithEncoding");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.html");

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setCharset(Charset.forName("shift_jis"));

        try (Viewer viewer = new Viewer(filePath, loadOptions)) {
            HtmlViewOptions options =
                    HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
