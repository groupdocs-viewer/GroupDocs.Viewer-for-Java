package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.ArchiveViewInfo;
import com.groupdocs.viewer.results.ViewInfo;

import java.io.FileNotFoundException;

public class GetViewInfoForArchiveFile {

    /**
     * This example demonstrates how to get view info for Archive files.
     */

    public static void run() throws FileNotFoundException {
        Viewer viewer = new Viewer(SampleFiles.SAMPLE_ZIP_WITH_FOLDERS);
        ViewInfo viewInfo = viewer.getViewInfo(ViewInfoOptions.forHtmlView());

        System.out.println("File type: " + viewInfo.getFileType());
        System.out.println("Pages count: " + viewInfo.getPages().size());
        System.out.println("Folders: ");
        System.out.println(" - /");

        String rootFolder = "";
        readFolders(viewer, rootFolder);
        viewer.close();

        System.out.println("\nView info retrieved successfully.");
    }

    private static void readFolders(Viewer viewer, String folder) {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
        viewInfoOptions.getArchiveOptions().setFolder(folder);

        ArchiveViewInfo viewInfo = (ArchiveViewInfo) viewer.getViewInfo(viewInfoOptions);

        for (String subFolder : viewInfo.getFolders()) {
            System.out.println(" - " + subFolder);

            readFolders(viewer, subFolder);
        }
    }
}