package com.groupdocs.ui.viewer.spring.common.util;

import com.groupdocs.ui.viewer.spring.common.exception.TotalGroupDocsException;
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

    @Test
    public void resolveInsideBaseDirectory_allowsNestedRelativeFile() throws Exception {
        Path base = Files.createTempDirectory("gd-viewer-base").toAbsolutePath();
        try {
            Path resolved = PathSecurityUtils.resolveInsideBaseDirectory(base.toString(), "folder/sample.pdf");
            assertEquals(base.resolve("folder/sample.pdf").normalize(), resolved);
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test
    public void resolveInsideBaseDirectoryOrRoot_allowsRootListing() throws Exception {
        Path base = Files.createTempDirectory("gd-viewer-base").toAbsolutePath();
        try {
            Path resolved = PathSecurityUtils.resolveInsideBaseDirectoryOrRoot(base.toString(), "");
            assertEquals(base.normalize(), resolved);
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
    public void resolveInsideBaseDirectory_rejectsAbsolutePath() throws Exception {
        Path base = Files.createTempDirectory("gd-viewer-base").toAbsolutePath();
        try {
            PathSecurityUtils.resolveInsideBaseDirectory(base.toString(), "/etc/passwd");
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test(expected = TotalGroupDocsException.class)
    public void resolveInsideBaseDirectory_rejectsFileUri() {
        PathSecurityUtils.resolveInsideBaseDirectory("/home/groupdocs/app/DocumentSamples", "file:///etc/passwd");
    }

    @Test
    public void sanitizeFileName_stripsDirectorySegments() {
        assertEquals("passwd", PathSecurityUtils.sanitizeFileName("../../etc/passwd"));
    }

    @Test(expected = TotalGroupDocsException.class)
    public void sanitizeFileName_rejectsParentDirectoryName() {
        PathSecurityUtils.sanitizeFileName("..");
    }

    @Test
    public void resolveInsideCacheDirectory_allowsResourceUnderCache() throws Exception {
        Path base = Files.createTempDirectory("gd-viewer-base").toAbsolutePath();
        try {
            Path resolved = PathSecurityUtils.resolveInsideCacheDirectory(
                    base.toString(), ".cache", "sample_docx", "p1.html");
            assertTrue(resolved.startsWith(base.resolve(".cache").normalize()));
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test(expected = TotalGroupDocsException.class)
    public void resolveInsideCacheDirectory_rejectsTraversalInResourceName() throws Exception {
        Path base = Files.createTempDirectory("gd-viewer-base").toAbsolutePath();
        try {
            PathSecurityUtils.resolveInsideCacheDirectory(base.toString(), ".cache", "sample_docx", "../secret.txt");
        } finally {
            Files.deleteIfExists(base);
        }
    }
}
