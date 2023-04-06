package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.TimeUnit;

import java.io.File;
import java.nio.file.Path;

public class AdjustTimeUnit {

    /**
     * This example demonstrates how to adjust time unit of the project.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("AdjustTimeUnit");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getProjectManagementOptions().setTimeUnit(TimeUnit.DAYS);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MPP)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}