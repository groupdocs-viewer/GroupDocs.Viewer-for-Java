package com.groupdocs.ui.viewer.dropwizard.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.Attachment;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class AttachmentModel implements Attachment {
    @JsonProperty("Id")
    private String mId;
    @JsonProperty("FileName")
    private String mFileName;
    @JsonProperty("filePath")
    private String mFilePath;
    @JsonProperty("Size")
    private long mSize;
    @JsonProperty("FileType")
    private String mFileType;

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

    @Override
    public void setId(String id) {
        mId = id;
    }

    @Override
    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    @Override
    public void setFilePath(String filePath) {
        mFilePath = filePath;
    }

    @Override
    public void setSize(long size) {
        mSize = size;
    }

    @Override
    public void setFileType(FileType fileType) {
        mFileType = fileType.name();
    }
}
