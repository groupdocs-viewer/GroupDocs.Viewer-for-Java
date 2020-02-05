package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import java.io.FileNotFoundException;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.Line;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ViewInfo;
import com.groupdocs.viewer.results.Word;

public class GetTextCoordinates {

    /**
     * This example demonstrates how to extract text from a document.
     */

    public static void run() throws FileNotFoundException {

        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forPngView(true);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX);
        ViewInfo viewInfo = viewer.getViewInfo(viewInfoOptions);
        viewer.close();

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