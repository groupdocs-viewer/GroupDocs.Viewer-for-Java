package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import org.testng.annotations.Test;

/**
 * This example demonstrates how to render RAR document into HTML, JPG, PNG, PDF.
 */
public class RenderingRarTests {

    @Test
    public void testRunToHtml() {
        RenderingRar.runToHtml();
    }

    @Test
    public void testRunToJpg() {
        RenderingRar.runToJpg();
    }

    @Test
    public void testRunToPng() {
        RenderingRar.runToPng();
    }

    @Test
    public void testRunToPdf() {
        RenderingRar.runToPdf();
    }

    @Test
    public void testGetViewInfoForRar() {
        RenderingRar.getViewInfoForRar();
    }

    @Test
    public void testRenderSpecificArchiveFolder() {
        RenderingRar.renderSpecificArchiveFolder();
    }
}
