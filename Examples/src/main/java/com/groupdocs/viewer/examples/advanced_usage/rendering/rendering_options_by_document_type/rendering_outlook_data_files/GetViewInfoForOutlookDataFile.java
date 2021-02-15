package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.OutlookViewInfo;

public class GetViewInfoForOutlookDataFile {

    /**
     * This example demonstrates how to get view info for Outlook data file.
     */

    public static void run() {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

        OutlookViewInfo viewInfo;
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_OST_SUBFOLDERS)) {
            viewInfo = (OutlookViewInfo) viewer.getViewInfo(viewInfoOptions);
        }

        System.out.println("File type is: " + viewInfo.getFileType());
        System.out.println("Pages count: " + viewInfo.getPages().size());
        for (String folder : viewInfo.getFolders()) {
            System.out.println(folder);
        }

        System.out.println("\nView info retrieved successfully.");
    }
}