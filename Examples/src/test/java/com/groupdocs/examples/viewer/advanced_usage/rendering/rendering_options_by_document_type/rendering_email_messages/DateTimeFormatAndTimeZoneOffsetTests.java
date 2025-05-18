package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to set custom date-time format and time zone offset
 */
public class DateTimeFormatAndTimeZoneOffsetTests {
    @Test
    public void run() {
        DateTimeFormatAndTimeZoneOffset.run(SampleFiles.SAMPLE_EML);
    }
}
