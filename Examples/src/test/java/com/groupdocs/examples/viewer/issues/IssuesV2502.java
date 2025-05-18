package com.groupdocs.examples.viewer.issues;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.examples.viewer.SampleFiles;
import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.options.ViewOptions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class IssuesV2502 {
    @Test
    public void testVIEWERJAVA3827() {
        final Path issueInputFile = SampleFiles.SAMPLE_ISSUE_3827;
        final Path outputPath = FilesUtils.makeOutputPath("IssuesV2502-3827-p{0}.html");

        ViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(outputPath);

        try (Viewer viewer = new Viewer(issueInputFile)) {
            viewer.view(viewOptions); // Must not fail
        }
    }

    @Test
    public void testVIEWERJAVA2863() {
        final Path issueInputFile = SampleFiles.SAMPLE_ISSUE_2863;
        final Path outputPath = FilesUtils.makeOutputPath("IssuesV2502-2863-p{0}.png");

        ViewOptions viewOptions = new PngViewOptions(outputPath);

        try (Viewer viewer = new Viewer(issueInputFile)) {
            viewer.view(viewOptions);
            System.out.printf("File %s must be checked manually (testVIEWERJAVA2863)%n", outputPath);
        }
    }

    @Test
    public void testVIEWERJAVA3288() {
        final Path issueInputFile = SampleFiles.SAMPLE_ISSUE_3288;
        final Path outputPath = FilesUtils.makeOutputPath("IssuesV2502-3288-p{0}.png");

        ViewOptions viewOptions = new PngViewOptions(outputPath);

        try (Viewer viewer = new Viewer(issueInputFile)) {
            viewer.view(viewOptions);
            System.out.printf("File %s must be checked manually (testVIEWERJAVA3288)%n", outputPath);
        }
    }
}
