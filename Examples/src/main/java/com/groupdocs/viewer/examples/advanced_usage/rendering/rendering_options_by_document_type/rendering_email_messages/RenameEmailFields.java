package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.Field;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class RenameEmailFields {

    /**
     * This example demonstrates how to rename fields when rendering email messages.
     */
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenameEmailFields");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        Map<Field, String> map = new HashMap<>();
        map.put(Field.FROM, "Sender");
        map.put(Field.TO, "Receiver");
        map.put(Field.SENT, "Date");
        map.put(Field.SUBJECT, "Topic");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getEmailOptions().setFieldTextMap(map);

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_MSG)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}