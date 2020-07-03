package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.Field;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RenameEmailFields {

    /**
     * This example demonstrates how to rename fields when rendering email messages.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("RenameEmailFields");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        Map<Field, String> map = new HashMap<Field, String>();
        map.put(Field.FROM, "Sender");
        map.put(Field.TO, "Receiver");
        map.put(Field.SENT, "Date");
        map.put(Field.SUBJECT, "Topic");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getEmailOptions().setFieldTextMap(map);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_MSG);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}