package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class FilterMessagesTests {

    /**
     * This example demonstrates how to filter messages by text/sender/recipient
     * when rendering Outlook data files.
     */
    @Test
    public void run() {
        FilterMessages.run(SampleFiles.SAMPLE_OST_SUBFOLDERS);
    }
}