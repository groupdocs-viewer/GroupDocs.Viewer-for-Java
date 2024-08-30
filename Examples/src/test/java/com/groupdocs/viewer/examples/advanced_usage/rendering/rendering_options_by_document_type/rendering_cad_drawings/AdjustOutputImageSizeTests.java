package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

public class AdjustOutputImageSizeTests {

    @BeforeMethod
    public void beforeMethod() {
        Locale.setDefault(Locale.US);
    }

    /**
     * This example demonstrates how to adjust output image size when rendering CAD
     * drawings.
     */
    @Test
    public void run() {
        AdjustOutputImageSize.run();
    }
}