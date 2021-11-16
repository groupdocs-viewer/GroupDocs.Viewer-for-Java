package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.*;

public class GetTextCoordinates {

    /**
     * This example demonstrates how to extract text from a document.
     */

    public static void run() {

        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forPngView(true);

        ViewInfo viewInfo;
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
            viewInfo = viewer.getViewInfo(viewInfoOptions);
        }

        for (Page page : viewInfo.getPages()) {
            System.out.println("Page: " + page.getNumber());
            System.out.println("Text lines/words/characters:");

            for (Line line : page.getLines()) {
                System.out.println(line);
                for (Word word : line.getWords()) {
                    System.out.println("\t" + word);
                    for (Character character : word.getCharacters()) {
                        System.out.println("\t\t" + character);
                    }
                }
            }
        }

        System.out.println("\nDocument text extracted successfully.\n");
    }
}