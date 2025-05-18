package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to split worksheet(s) into page(s).
 */
public class SplitWorksheetsIntoPagesTests {

    @Test
    public static void splitByRows() {
        SplitWorksheetsIntoPages.splitByRows(SampleFiles.TWO_PAGES_XLSX);
    }

    @Test
    public static void splitByRowsAndColumns() {
        SplitWorksheetsIntoPages.splitByRowsAndColumns(SampleFiles.FOUR_PAGES_XLSX);
    }
}