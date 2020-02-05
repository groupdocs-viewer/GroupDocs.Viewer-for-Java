package com.groupdocs.viewer.examples.basic_usage;

import com.groupdocs.viewer.FileType;

import java.util.List;

public class GetSupportedFileFormats {

    /**
     * This examples demonstrates how to print out all supported file types.
     */

    public static void run() {
        List<FileType> fileTypes = FileType.getSupportedFileTypes();

        for (FileType fileType : fileTypes) {
            System.out.println(fileType);
        }

        System.out.println("\nSupported file types retrieved successfully.");
    }
}