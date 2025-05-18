package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to retrieve and print worksheets names.
 */
public class GetWorksheetsNamesTests {
    @Test
    public void run() {
        GetWorksheetsNames.run(SampleFiles.THREE_SHEETS);
    }
}
