package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents;

import java.io.File;
import java.io.IOException;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.ProjectManagementViewInfo;

public class RenderProjectTimeInterval {

    /**
     * This example demonstrates how to render project document within the specified
     * time interval.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderProjectTimeInterval");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_MPP);

        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
        ProjectManagementViewInfo viewInfo = (ProjectManagementViewInfo) viewer.getViewInfo(viewInfoOptions);

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getProjectManagementOptions().
            setStartDate(viewInfo.getStartDate());
        viewOptions.getProjectManagementOptions().
            setEndDate(viewInfo.getEndDate());

        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}