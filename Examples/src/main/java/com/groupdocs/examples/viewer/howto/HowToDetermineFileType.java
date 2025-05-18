package com.groupdocs.examples.viewer.howto;

import com.groupdocs.examples.viewer.SampleFiles;
import com.groupdocs.viewer.FileType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This example demonstrates how to determine file type when you have file extension, media-type or stream.
 */
public class HowToDetermineFileType {
    public static void fromFileExtension() {
        String extension = ".docx";
        FileType fileType = FileType.fromExtension(extension);

        System.out.println("\nExtension " + extension + "; File type: " + fileType);
    }

    public static void fromMediaType() {
        String mediaType = "application/pdf";
        FileType fileType = FileType.fromMediaType(mediaType);

        System.out.println("\nMedia-type " + mediaType + "; File type: " + fileType);
    }

    public static void fromStream() {
        try (InputStream inputStream = new FileInputStream(SampleFiles.SAMPLE_DOCX.toString())) {
            FileType fileType = FileType.fromStream(inputStream);

            System.out.println("\nFile path " + SampleFiles.SAMPLE_DOCX.toString() + "; File type: " + fileType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
