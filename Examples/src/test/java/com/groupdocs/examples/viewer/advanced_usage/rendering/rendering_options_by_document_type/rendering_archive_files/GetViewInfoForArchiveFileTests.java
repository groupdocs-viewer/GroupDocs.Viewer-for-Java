package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class GetViewInfoForArchiveFileTests {

    /**
     * This example demonstrates how to get view info for Archive files.
     */
    @Test(timeOut = 60000)
    public void run() {
        GetViewInfoForArchiveFile.run(SampleFiles.SAMPLE_ZIP_WITH_FOLDERS);
    }
}