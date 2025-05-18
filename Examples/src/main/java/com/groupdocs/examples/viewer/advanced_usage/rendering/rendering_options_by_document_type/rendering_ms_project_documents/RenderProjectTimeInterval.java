package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.ProjectManagementViewInfo;

import java.nio.file.Path;

public class RenderProjectTimeInterval {

    /**
     * This example demonstrates how to render project document within the specified
     * time interval.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderProjectTimeInterval");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        try (Viewer viewer = new Viewer(inputFile)) {

            ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
            ProjectManagementViewInfo viewInfo = (ProjectManagementViewInfo) viewer.getViewInfo(viewInfoOptions);

            HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            viewOptions.getProjectManagementOptions().
                    setStartDate(viewInfo.getStartDate());
            viewOptions.getProjectManagementOptions().
                    setEndDate(viewInfo.getEndDate());

            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}