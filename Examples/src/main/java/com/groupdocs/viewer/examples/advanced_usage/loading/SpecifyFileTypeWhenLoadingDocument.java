package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

import java.io.File;

public class SpecifyFileTypeWhenLoadingDocument {

    /**
     * This example demonstrates how to specify file type when loading document.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("SpecifyFileTypeWhenLoadingDocument");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setFileType(FileType.DOCX);

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX, loadOptions)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}