package com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class AdjustQualityOfJpgImagesTests {

    /**
     * This example demonstrates how to adjust quality of JPG images of the output PDF document.
     */
    @Test
    public void run() {
        AdjustQualityOfJpgImages.run(SampleFiles.JPG_IMAGE_PPTX);
    }
}