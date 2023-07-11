package com.groupdocs.viewer.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import org.apache.commons.net.ftp.FTPClient;

import java.io.InputStream;
import java.nio.file.Path;

public class LoadDocumentFromFtp {

    /**
     * This example demonstrates how to render document downloaded from FTP.
     */
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("LoadDocumentFromFtp");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");
        String server = "localhost";
        String filePath = "sample.doc";

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(getFileFromFtp(server, filePath))) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }

    private static InputStream getFileFromFtp(String server, String filePath) {
        try {
            FTPClient client = new FTPClient();
            client.connect(server);
            InputStream inputStream = client.retrieveFileStream(filePath);
            client.disconnect();

            return inputStream;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}