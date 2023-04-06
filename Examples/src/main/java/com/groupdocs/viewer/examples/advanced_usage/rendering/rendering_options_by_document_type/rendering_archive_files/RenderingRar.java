package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.ArchiveViewInfo;
import com.groupdocs.viewer.results.ViewInfo;

import java.nio.file.Path;

/**
 * This example demonstrates how to render RAR document into HTML, JPG, PNG, PDF.
 */
public class RenderingRar {
    public static void run() {
        runToHtml();
        runToJpg();
        runToPng();
        runToPdf();

        getViewInfoForRar();
        renderSpecificArchiveFolder();
    }

    public static void runToHtml() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingRar");
        Path pageFilePathFormat = outputDirectory.resolve("RAR_result_{0}.html");

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    public static void runToJpg() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingRar");
        // TO JPG
        Path pageFilePathFormat = outputDirectory.resolve("RAR_result_{0}.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    public static void runToPng() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingRar");
        // TO PNG
        Path pageFilePathFormat = outputDirectory.resolve("RAR_result_{0}.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    public static void runToPdf() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingRar");
        // TO PDF
        Path pageFilePathFormat = outputDirectory.resolve("RAR_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    /**
     * This example demonstrates how to get view info for Archive files.
     */
    public static void getViewInfoForRar() {
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
    public static void renderSpecificArchiveFolder() {

        Path outputDirectory = Utils.getOutputDirectoryPath("RenderSpecificArchiveFolder");
        Path pageFilePathFormat = outputDirectory.resolve("archive_folder_page_{0}.html");

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
