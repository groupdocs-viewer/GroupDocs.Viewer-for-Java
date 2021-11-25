package com.groupdocs.ui.viewer.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ViewInfo;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class ViewInfoModel implements ViewInfo {
    @JsonProperty("FileType")
    private final String mFileType;
    @JsonProperty("Pages")
    private final List<Page> mPages;

    @JsonCreator
    public ViewInfoModel(@JsonProperty("FileType") String fileType, @JsonProperty("Pages") List<Page> pages) {
        mFileType = fileType;
        mPages = pages;
    }

    @Override
    public FileType getFileType() {
        return FileType.valueOf(mFileType);
    }

    @Override
    public List<Page> getPages() {
        return mPages;
    }
}
