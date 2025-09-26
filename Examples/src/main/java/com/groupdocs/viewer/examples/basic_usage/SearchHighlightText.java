package com.groupdocs.viewer.examples.basic_usage;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.options.SearchHighlightOptions;

public class SearchHighlightText {
    public static void search() {

        // Creating two instances of SearchHighlightOptions and adjusting them
        SearchHighlightOptions byLiteral = new SearchHighlightOptions();
        byLiteral.setSearchTerm("some text");
        byLiteral.setSearchTermRegEx(false);

        SearchHighlightOptions byRegEx = new SearchHighlightOptions();
        byRegEx.setSearchTerm("text\\s*#(\\d+)");
        byRegEx.setSearchTermRegEx(true);

        // Loading two documents to the two instances of Viewer class
        try (Viewer docxViewer = new Viewer(TestFiles.SAMPLE_DOCX);
             Viewer pdfViewer = new Viewer(TestFiles.SAMPLE_PDF)) {
            // Performing search in both Viewer instances
            docxViewer.search(byLiteral);
            pdfViewer.search(byRegEx);

            // Rendering both documents - 1st to HTML and 2nd to PNG
            docxViewer.view(HtmlViewOptions.forEmbeddedResources());
            pdfViewer.view(new PngViewOptions());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nSuccessfully search highlight text.");
    }
}
