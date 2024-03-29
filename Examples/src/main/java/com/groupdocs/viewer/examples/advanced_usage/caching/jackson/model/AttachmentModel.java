package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.Attachment;

public class AttachmentModel implements Attachment {
    @JsonProperty("Id")
    private final String mId;
    @JsonProperty("FileName")
    private final String mFileName;
    @JsonProperty("filePath")
    private final String mFilePath;
    @JsonProperty("Size")
    private final long mSize;
    @JsonProperty("FileType")
    private String mFileType;

    @JsonCreator
    public AttachmentModel(@JsonProperty("Id") String id, @JsonProperty("FileName") String fileName, @JsonProperty("FilePath") String filePath, @JsonProperty("Size") long size) {
        mId = id;
        mFileName = fileName;
        mSize = size;
        mFilePath = filePath;
    }

    @JsonCreator
    public AttachmentModel(@JsonProperty("Id") String id, @JsonProperty("FileName") String fileName, @JsonProperty("FilePath") String filePath, @JsonProperty("FileType") FileType fileType, @JsonProperty("Size") long size) {
        mId = id;
        mFileName = fileName;
        mSize = size;
        mFilePath = filePath;
        mFileType = fileType.name();
    }

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public String getFileName() {
        return mFileName;
    }

    @Override
    public String getFilePath() {
        return mFilePath;
    }

    @Override
    public long getSize() {
        return mSize;
    }

    @Override
    public FileType getFileType() {
        return FileType.valueOf(mFileType);
    }
}
