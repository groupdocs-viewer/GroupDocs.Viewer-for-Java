package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.TimeUnit;

import java.io.File;
import java.io.IOException;

public class AdjustTimeUnit {

    /**
     * This example demonstrates how to adjust time unit of the project.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustTimeUnit");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getProjectManagementOptions().setTimeUnit(TimeUnit.DAYS);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_MPP);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}