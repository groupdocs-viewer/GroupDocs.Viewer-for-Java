package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.FileInfo;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class FileInfoModel implements FileInfo {
    @JsonProperty("FileType")
    private String mFileType;
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

    @Override
    public void setFileType(FileType fileType) {
        this.mFileType = fileType.name();
    }
}
