package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render MS Project document into HTML, JPG, PNG, PDF with notes.
 */
public class RenderingNotesTests {
    @Test
    public void run() {
        RenderingNotes.run(SampleFiles.SAMPLE_MPP);
    }
}
