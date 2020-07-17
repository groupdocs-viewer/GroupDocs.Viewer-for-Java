package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;
import com.groupdocs.viewer.utils.PathUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class LoadDocumentsWithCharset {

    /**
     * This example demonstrates how to specify charset.
     */

    public static void run() throws IOException {
        String filePath = SampleFiles.SAMPLE_TXT_SHIFT_JS_ENCODED;
        String outputDirectory = Utils.getOutputDirectoryPath("LoadDocumentsWithEncoding");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "page_{0}.html");

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setFileType(FileType.TXT);
        loadOptions.setCharset(Charset.forName("shift_jis"));

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        Viewer viewer = new Viewer(filePath, loadOptions);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}