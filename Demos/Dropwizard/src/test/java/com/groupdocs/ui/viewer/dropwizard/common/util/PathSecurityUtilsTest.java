package com.groupdocs.ui.viewer.dropwizard.common.util;

import com.groupdocs.ui.viewer.dropwizard.common.exception.TotalGroupDocsException;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PathSecurityUtilsTest {

    @Test
    public void resolveInsideBaseDirectory_allowsRelativeFile() throws Exception {
        Path base = Files.createTempDirectory("gd-viewer-base").toAbsolutePath();
        try {
            Path resolved = PathSecurityUtils.resolveInsideBaseDirectory(base.toString(), "sample.docx");
            assertEquals(base.resolve("sample.docx").normalize(), resolved);
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test(expected = TotalGroupDocsException.class)
    public void resolveInsideBaseDirectory_rejectsPathTraversal() throws Exception {
        Path base = Files.createTempDirectory("gd-viewer-base").toAbsolutePath();
        try {
            PathSecurityUtils.resolveInsideBaseDirectory(base.toString(), "../../../etc/passwd");
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test(expected = TotalGroupDocsException.class)
    public void resolveInsideBaseDirectory_rejectsFileUri() {
        PathSecurityUtils.resolveInsideBaseDirectory("/home/groupdocs/app/DocumentSamples", "file:///etc/passwd");
    }
}
