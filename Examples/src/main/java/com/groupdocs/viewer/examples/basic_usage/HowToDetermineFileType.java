package com.groupdocs.viewer.examples.basic_usage;

import com.groupdocs.viewer.FileType;
import org.apache.commons.lang3.NotImplementedException;

import java.io.IOException;

public class HowToDetermineFileType {
    public static void fromFileExtension() {
        String extension = ".docx";
        FileType fileType = FileType.fromExtension(extension);

        System.out.println("\nExtension " + extension + "; File type: " + fileType + ".");
    }

    public static void fromMediaType() {
        throw new NotImplementedException("Will be implemented in the next version of GroupDocs.Viewer for Java");
//        String mediaType = "application/pdf";
//        FileType fileType = FileType.fromMediaType(mediaType);
//
//        System.out.println("\nMedia-type " + mediaType + "; File type: " + fileType + ".");
    }

    public static void fromStream() throws IOException {
        throw new NotImplementedException("Will be implemented in the next version of GroupDocs.Viewer for Java");
//        try (InputStream stream = new FileInputStream(SampleFiles.SAMPLE_DOCX)) {
//            FileType fileType = FileType.fromStream(stream);
//
//            System.out.println("\nFile path " + SampleFiles.SAMPLE_DOCX + "; File type: " + fileType + ".");
//        }
    }
}
