package com.groupdocs.viewer.examples.basic_usage;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.results.FileInfo;

/**
 * This example demonstrates how to check if the file is encrypted.
 */
public class CheckFileIsEncrypted {
    public static void run() {
        try (Viewer viewer = new Viewer(SampleFiles.ENCRYPTED)) {
            FileInfo fileInfo = viewer.getFileInfo();

            System.out.println("File type is: " + fileInfo.getFileType());
            System.out.println("File encrypted: " + fileInfo.isEncrypted());
        }

        System.out.println("\nFile info retrieved successfully.");
    }
}
