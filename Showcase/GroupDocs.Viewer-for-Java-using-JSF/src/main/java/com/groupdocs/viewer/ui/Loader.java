package com.groupdocs.viewer.ui;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@ViewScoped
@Named("loader")
public class Loader implements Serializable {

    // TODO: Allow user to load another file from UI.
    private String guid = "sample.pptx";

    private byte[] buffer;

    public InputStream getInputStream() {
        if (this.buffer == null) {
            Path p = Utils.getStoragePath().resolve(this.guid);

            try {
                int size = (int) Files.size(p);
                ByteArrayOutputStream holder = new ByteArrayOutputStream(size);
                Files.copy(p, holder);
                buffer = holder.toByteArray();
            } catch (IOException x) {
                throw new RuntimeException(x);
            }
        }

        return new ByteArrayInputStream(buffer);
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
        this.buffer = null;
    }

}

