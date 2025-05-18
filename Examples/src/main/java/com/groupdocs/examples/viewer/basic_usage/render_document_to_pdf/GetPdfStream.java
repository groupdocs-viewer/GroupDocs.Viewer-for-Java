package com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.interfaces.FileStreamFactory;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.io.*;
import java.nio.file.Path;

/**
 * This example demonstrates how to convert file to PDF and get PDF file stream.
 */
public class GetPdfStream {
    public static void run(Path inputFile) {
        try (Viewer viewer = new Viewer(inputFile);
             MemoryFileStreamFactory streamFactory = new MemoryFileStreamFactory()) {

            PdfViewOptions options = new PdfViewOptions(streamFactory);

            viewer.view(options);

            // Return or write stream
            InputStream stream = streamFactory.getStream();

            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nSource document rendered successfully.");
    }

    private static class MemoryFileStreamFactory implements FileStreamFactory, Closeable {
        private final ByteArrayOutputStream mArrayOutputStream;

        public MemoryFileStreamFactory() {
            this.mArrayOutputStream = new ByteArrayOutputStream();
        }

        @Override
        public OutputStream createFileStream() {
            return mArrayOutputStream;
        }

        @Override
        public void closeFileStream(OutputStream outputStream) {
            //Do not dispose stream here
        }

        public InputStream getStream() {
            return new ByteArrayInputStream(mArrayOutputStream.toByteArray());
        }

        @Override
        public void close() throws IOException {
            mArrayOutputStream.close();
        }
    }
}
