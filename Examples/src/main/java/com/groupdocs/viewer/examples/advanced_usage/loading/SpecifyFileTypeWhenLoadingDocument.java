package com.groupdocs.viewer.examples.advanced_usage.loading;

import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.LoadOptions;

import java.io.File;
import java.io.IOException;

public class SpecifyFileTypeWhenLoadingDocument {

    /**
     * This example demonstrates how to specify file type when loading document.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("SpecifyFileTypeWhenLoadingDocument");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setFileType(FileType.DOCX);

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX, loadOptions);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}