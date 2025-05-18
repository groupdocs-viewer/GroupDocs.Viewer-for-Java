package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import com.groupdocs.examples.viewer.utils.FilesUtils;
import org.testng.annotations.Test;

import java.nio.file.Path;

/**
 * This example demonstrates how to render OBJ document into HTML, JPG, PNG, PDF.
 */
public class RenderingObjTests {
    @Test
    public void runToHtml() {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.html");

        RenderingObj.runToHtml(SampleFiles.SAMPLE_OBJ, pageFilePathFormat);
    }

    @Test
    public void runToJpg() {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.jpg");

        RenderingObj.runToJpg(SampleFiles.SAMPLE_OBJ, pageFilePathFormat);
    }

    @Test
    public void runToPng() {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.png");

        RenderingObj.runToPng(SampleFiles.SAMPLE_OBJ, pageFilePathFormat);
    }

    @Test(timeOut = 180_000)
    public void runToPdf() {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.png");

        RenderingObj.runToPdf(SampleFiles.SAMPLE_OBJ, pageFilePathFormat);
    }
}
