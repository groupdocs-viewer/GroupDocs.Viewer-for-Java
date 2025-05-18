package com.groupdocs.examples.viewer.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class LoadDocumentFromLocalDiskTests {

    /**
     * This example demonstrates how to render document from local disk.
     */
    @Test
    public void run() {
        LoadDocumentFromLocalDisk.run(SampleFiles.SAMPLE_DOCX);
    }
}