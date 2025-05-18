package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderArchiveFolderTests {

    /**
     * This example demonstrates how to render folder of archive file.
     */
    @Test
    public void run() {
        RenderArchiveFolder.run(SampleFiles.SAMPLE_ZIP_WITH_FOLDERS);
    }
}