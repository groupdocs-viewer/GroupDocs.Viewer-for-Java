package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class RenderArchiveFolder {

    /**
     * This example demonstrates how to render folder of archive file.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderArchiveFolder");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getArchiveOptions().setFolder("ThirdFolderWithItems");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_ZIP_WITH_FOLDERS)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}