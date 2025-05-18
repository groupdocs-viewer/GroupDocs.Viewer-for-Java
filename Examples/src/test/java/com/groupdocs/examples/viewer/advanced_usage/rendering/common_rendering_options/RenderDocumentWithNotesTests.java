package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderDocumentWithNotesTests {

    /**
     * This example demonstrates how to render presentation with notes.
     */
    @Test
    public void run() {
        RenderDocumentWithNotes.run(SampleFiles.PPTX_WITH_NOTES);
    }
}