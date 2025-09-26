package com.groupdocs.viewer.examples.basic_usage;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.fonts.FontFormat;
import com.groupdocs.viewer.fonts.FontStyles;
import com.groupdocs.viewer.fonts.UsedFontInfo;

import java.util.List;

public class GetAllFonts {
    public static void run() {
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            List<UsedFontInfo> list = viewer.getAllFonts();
            for (UsedFontInfo font : list) {
                System.out.printf(
                        "%s font '%s' of '%s' style has %d bytes and is of '%s' format%n",
                        font.isEmbedded() ? "Embedded" : "System",
                        font.getName(),
                        FontStyles.toString(font.getStyle()),
                        font.getContent().length,
                        FontFormat.toString(font.getFormat())
                );
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("\nSuccessfully extracted all fonts.");
    }
}
