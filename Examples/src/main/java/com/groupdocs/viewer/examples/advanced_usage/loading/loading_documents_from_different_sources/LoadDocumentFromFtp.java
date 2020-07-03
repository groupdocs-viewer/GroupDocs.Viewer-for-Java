package com.groupdocs.viewer.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LoadDocumentFromFtp {

    /**
     * This example demonstrates how to render document downloaded from FTP.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("LoadDocumentFromFtp");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();
        String server = "localhost";
        String filePath = "sample.doc";

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        Viewer viewer = new Viewer(getFileFromFtp(server, filePath));
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }

    private static InputStream getFileFromFtp(String server, String filePath) throws IOException {
        FTPClient client = new FTPClient();
        client.connect(server);
        InputStream inputStream = client.retrieveFileStream(filePath);
        client.disconnect();

        return inputStream;
    }
}