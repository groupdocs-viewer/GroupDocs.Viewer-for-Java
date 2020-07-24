package com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.Permissions;
import com.groupdocs.viewer.options.Security;

import java.io.File;
import java.io.IOException;

public class ProtectPdfDocument {

    /**
     * This example demonstrates how to protect output PDF document.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("ProtectPdfDocument");
        String filePath = new File(outputDirectory, "output.pdf").getPath();

        Security security = new Security();
        security.setDocumentOpenPassword("o123");
        security.setPermissionsPassword("p123");
        security.setPermissions(Permissions.ALLOW_ALL ^ Permissions.DENY_PRINTING);

        PdfViewOptions viewOptions = new PdfViewOptions(filePath);
        viewOptions.setSecurity(security);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}