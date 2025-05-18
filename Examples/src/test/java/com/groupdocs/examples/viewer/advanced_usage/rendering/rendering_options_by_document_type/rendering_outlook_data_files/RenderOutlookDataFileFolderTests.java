package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderOutlookDataFileFolderTests {

    /**
     * This example demonstrates how to render messages from Inbox folder of Outlook
     * data file.
     */
    @Test
    public void run() {
        RenderOutlookDataFileFolder.run(SampleFiles.SAMPLE_OST_SUBFOLDERS);
    }
}