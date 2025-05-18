package com.groupdocs.examples.viewer.basic_usage;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.results.FileInfo;

import java.nio.file.Path;

/**
 * This example demonstrates how to check if the file is encrypted.
 */
public class CheckFileIsEncrypted {
    public static void run(Path inputFile) {
        try (Viewer viewer = new Viewer(inputFile)) {
            FileInfo fileInfo = viewer.getFileInfo();

            System.out.println("File type is: " + fileInfo.getFileType());
            System.out.println("File encrypted: " + fileInfo.isEncrypted());
        }

        System.out.println("\nFile info retrieved successfully.");
    }
}
