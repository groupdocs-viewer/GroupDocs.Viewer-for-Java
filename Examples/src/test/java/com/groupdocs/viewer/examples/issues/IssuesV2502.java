package com.groupdocs.viewer.examples.issues;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.utils.FilesUtils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.options.ViewOptions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class IssuesV2502 {
    @Test
    public void testVIEWERJAVA3827() {
        final Path issueInputFile = SampleFiles.INPUT_FILES_DIRECTORY.resolve("issues/IssuesV2502/preview_test_pdf.pdf");
        final Path outputPath = FilesUtils.makeOutputPath("IssuesV2502-3827-p{0}.html");

        ViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(outputPath);

        try (Viewer viewer = new Viewer(issueInputFile)) {
            viewer.view(viewOptions); // Must not fail
        }
    }

    @Test
    public void testVIEWERJAVA2863() {
        final Path issueInputFile = SampleFiles.INPUT_FILES_DIRECTORY.resolve("issues/IssuesV2502/short-archive.zip");
        final Path outputPath = FilesUtils.makeOutputPath("IssuesV2502-2863-p{0}.png");

        ViewOptions viewOptions = new PngViewOptions(outputPath);

        try (Viewer viewer = new Viewer(issueInputFile)) {
            viewer.view(viewOptions);
            System.out.printf("File %s must be checked manually (testVIEWERJAVA2863)%n", outputPath);
        }
    }

    @Test
    public void testVIEWERJAVA3288() {
        final Path issueInputFile = SampleFiles.INPUT_FILES_DIRECTORY.resolve("issues/IssuesV2502/long-archive.zip");
        final Path outputPath = FilesUtils.makeOutputPath("IssuesV2502-3288-p{0}.png");

        ViewOptions viewOptions = new PngViewOptions(outputPath);

        try (Viewer viewer = new Viewer(issueInputFile)) {
            viewer.view(viewOptions);
            System.out.printf("File %s must be checked manually (testVIEWERJAVA3288)%n", outputPath);
        }
    }
}
