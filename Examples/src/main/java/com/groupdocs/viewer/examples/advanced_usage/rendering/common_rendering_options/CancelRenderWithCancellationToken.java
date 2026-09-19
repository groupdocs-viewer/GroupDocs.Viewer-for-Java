package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;
import com.groupdocs.viewer.utils.CancellationToken;
import com.groupdocs.viewer.utils.CancellationTokenSource;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CancelRenderWithCancellationToken {

    /**
     * This example demonstrates how to cancel document rendering using a
     * cancellation token.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("CancelRenderWithCancellationToken");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        try (CancellationTokenSource cancellationTokenSource = new CancellationTokenSource()) {
            CancellationToken cancellationToken = cancellationTokenSource.getToken();

            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DOCX)) {
                    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
                    viewOptions.setRenderComments(true);
                    viewer.view(viewOptions, cancellationToken);
                }
            });

            // Cancel task after 1000 ms.
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.schedule(cancellationTokenSource::cancel, 1000, TimeUnit.MILLISECONDS);

            // Also you can call cancel() at any time:
            // cancellationTokenSource.cancel();

            // Wait for the task to cancel.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            scheduler.shutdownNow();
            executor.shutdownNow();

            if (cancellationToken.isCancellationRequested()) {
                System.out.println("\nRendering was canceled.");
            } else {
                System.out.println(
                        "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
            }
        }
    }
}
