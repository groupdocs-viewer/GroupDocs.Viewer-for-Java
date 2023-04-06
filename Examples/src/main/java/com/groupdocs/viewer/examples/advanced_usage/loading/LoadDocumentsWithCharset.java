package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

import java.nio.charset.Charset;
import java.nio.file.Path;

public class LoadDocumentsWithCharset {

    /**
     * This example demonstrates how to specify charset.
     */

    public static void run() {
        String filePath = TestFiles.SAMPLE_TXT_SHIFT_JS_ENCODED;
        Path outputDirectory = Utils.getOutputDirectoryPath("LoadDocumentsWithEncoding");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setFileType(FileType.TXT);
        loadOptions.setCharset(Charset.forName("shift_jis"));

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(filePath, loadOptions)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}