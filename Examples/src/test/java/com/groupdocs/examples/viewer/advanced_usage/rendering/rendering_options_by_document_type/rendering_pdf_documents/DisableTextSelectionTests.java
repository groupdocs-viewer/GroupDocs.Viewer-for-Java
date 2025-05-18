package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to disable text selection when rendering PDF documents to HTML.
 */
public class DisableTextSelectionTests {
    @Test
    public void run() {
        DisableTextSelection.run(SampleFiles.ONE_PAGE_TEXT_PDF);
    }
}
