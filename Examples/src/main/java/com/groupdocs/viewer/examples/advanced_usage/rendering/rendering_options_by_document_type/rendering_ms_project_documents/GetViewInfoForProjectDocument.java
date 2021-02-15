package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.ProjectManagementViewInfo;

public class GetViewInfoForProjectDocument {

    /**
     * This example demonstrates how to get view info for MS Project document.
     */

    public static void run() {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

        ProjectManagementViewInfo info;
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_MPP)) {
            info = (ProjectManagementViewInfo) viewer.getViewInfo(viewInfoOptions);
        }

        System.out.println("Document type is: " + info.getFileType());
        System.out.println("Pages count: " + info.getPages().size());
        System.out.println("Project start date: " + info.getStartDate());
        System.out.println("Project end date: " + info.getEndDate());

        System.out.println("\nView info retrieved successfully.");
    }
}