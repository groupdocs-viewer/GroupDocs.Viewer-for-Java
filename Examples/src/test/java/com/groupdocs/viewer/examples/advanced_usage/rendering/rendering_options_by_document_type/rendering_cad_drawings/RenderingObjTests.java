package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.examples.Utils;
import org.testng.annotations.Test;

import java.nio.file.Path;

/**
 * This example demonstrates how to render OBJ document into HTML, JPG, PNG, PDF.
 */
public class RenderingObjTests {
    @Test
    public void runToHtml() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.html");

        RenderingObj.runToHtml(pageFilePathFormat);
    }

    @Test
    public void runToJpg() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.jpg");

        RenderingObj.runToJpg(pageFilePathFormat);
    }

    @Test
    public void runToPng() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.png");

        RenderingObj.runToPng(pageFilePathFormat);
    }

    @Test(timeOut = 180_000)
    public void runToPdf() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingObj");
        Path pageFilePathFormat = outputDirectory.resolve("obj_result.png");

        RenderingObj.runToPdf(pageFilePathFormat);
    }
}
