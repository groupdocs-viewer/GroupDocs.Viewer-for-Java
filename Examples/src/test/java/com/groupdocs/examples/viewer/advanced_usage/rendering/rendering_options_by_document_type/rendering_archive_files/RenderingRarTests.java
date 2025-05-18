package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render RAR document into HTML, JPG, PNG, PDF.
 */
public class RenderingRarTests {

    @Test
    public void testRunToHtml() {
        RenderingRar.runToHtml(SampleFiles.SAMPLE_RAR_WITH_FOLDERS);
    }

    @Test
    public void testRunToJpg() {
        RenderingRar.runToJpg(SampleFiles.SAMPLE_RAR_WITH_FOLDERS);
    }

    @Test
    public void testRunToPng() {
        RenderingRar.runToPng(SampleFiles.SAMPLE_RAR_WITH_FOLDERS);
    }

    @Test
    public void testRunToPdf() {
        RenderingRar.runToPdf(SampleFiles.SAMPLE_RAR_WITH_FOLDERS);
    }

    @Test(timeOut = 90000)
    public void testGetViewInfoForRar() {
        RenderingRar.getViewInfoForRar(SampleFiles.SAMPLE_RAR_WITH_FOLDERS);
    }

    @Test
    public void testRenderSpecificArchiveFolder() {
        RenderingRar.renderSpecificArchiveFolder(SampleFiles.SAMPLE_RAR_WITH_FOLDERS);
    }
}
