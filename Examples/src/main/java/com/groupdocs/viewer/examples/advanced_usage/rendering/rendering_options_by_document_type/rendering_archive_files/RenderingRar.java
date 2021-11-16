package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.ArchiveViewInfo;
import com.groupdocs.viewer.results.ViewInfo;

/**
 * This example demonstrates how to render RAR document into HTML, JPG, PNG, PDF.
 */
public class RenderingRar {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingRar");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "RAR_result_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "RAR_result_{0}.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "RAR_result_{0}.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "RAR_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        getViewInfoForRar();
        renderSpecificArchiveFolder();

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);

    }

    /**
     * This example demonstrates how to get view info for Archive files.
     */
    private static void getViewInfoForRar() {
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            ViewInfo info = viewer.getViewInfo(ViewInfoOptions.forHtmlView());

            System.out.println("File type: " + info.getFileType());
            System.out.println("Pages count: " + info.getPages().size());

            System.out.println("Folders: ");
            System.out.println(" - /");

            String rootFolder = "";
            readFolders(viewer, rootFolder);
        }

        System.out.println("\nView info retrieved successfully.");
    }

    /**
     * This example demonstrates how to render folder of archive file.
     */
    private static void renderSpecificArchiveFolder() {

        String outputDirectory = Utils.getOutputDirectoryPath("RenderSpecificArchiveFolder");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "archive_folder_page_{0}.html");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            options.getArchiveOptions().setFolder("with_folders\\ThirdFolderWithItems");

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    private static void readFolders(Viewer viewer, String folder) {
        ViewInfoOptions options = ViewInfoOptions.forHtmlView();
        options.getArchiveOptions().setFolder(folder);

        ArchiveViewInfo viewInfo = (ArchiveViewInfo) viewer.getViewInfo(options);

        for (String subFolder : viewInfo.getFolders()) {
            System.out.println(" - " + subFolder);

            readFolders(viewer, subFolder);
        }
    }
}
