package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_word_processing_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderTrackedChangesTests {

    /**
     * This example demonstrates how to render tracked changes.
     */
    @Test
    public void run() {
        RenderTrackedChanges.run(SampleFiles.SAMPLE_DOCX_WITH_TRACKED_CHANGES);
    }
}