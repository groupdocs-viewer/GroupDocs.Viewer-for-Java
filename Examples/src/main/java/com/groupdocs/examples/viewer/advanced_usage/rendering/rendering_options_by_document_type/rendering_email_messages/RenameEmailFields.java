package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.Field;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class RenameEmailFields {

    /**
     * This example demonstrates how to rename fields when rendering email messages.
     */
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenameEmailFields");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        Map<Field, String> map = new HashMap<>();
        map.put(Field.FROM, "Sender");
        map.put(Field.TO, "Receiver");
        map.put(Field.SENT, "Date");
        map.put(Field.SUBJECT, "Topic");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getEmailOptions().setFieldTextMap(map);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}