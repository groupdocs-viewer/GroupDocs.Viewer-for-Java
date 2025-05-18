package com.groupdocs.examples.viewer.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class LoadDocumentFromStreamTests {

    /**
     * This example demonstrates how to render document from stream.
     */
    @Test
    public void run() {
        LoadDocumentFromStream.run(SampleFiles.SAMPLE_DOCX);
    }

}