package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.FileInfo;

public class FileInfoModel implements FileInfo {
    @JsonProperty("FileType")
    private final String mFileType;
    @JsonProperty("Encrypted")
    private boolean mEncrypted;

    @JsonCreator
    public FileInfoModel(@JsonProperty("FileType") String fileType) {
        mFileType = fileType;
    }

    @Override
    public FileType getFileType() {
        return FileType.valueOf(mFileType);
    }

    @Override
    public boolean isEncrypted() {
        return mEncrypted;
    }

    @Override
    public void setEncrypted(boolean encrypted) {
        mEncrypted = encrypted;
    }
}
