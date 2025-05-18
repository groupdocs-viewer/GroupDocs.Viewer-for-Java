package com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.Permissions;
import com.groupdocs.viewer.options.Security;

import java.nio.file.Path;

public class ProtectPdfDocument {

    /**
     * This example demonstrates how to protect output PDF document.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("ProtectPdfDocument");
        Path filePath = outputDirectory.resolve("output.pdf");

        Security security = new Security();
        security.setDocumentOpenPassword("o123");
        security.setPermissionsPassword("p123");
        security.setPermissions(Permissions.ALLOW_ALL ^ Permissions.DENY_PRINTING);

        PdfViewOptions viewOptions = new PdfViewOptions(filePath);
        viewOptions.setSecurity(security);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}