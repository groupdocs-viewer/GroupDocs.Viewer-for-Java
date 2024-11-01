package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.ArchiveViewInfo;
import com.groupdocs.viewer.results.Page;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class ArchiveViewInfoModel extends ViewInfoModel implements ArchiveViewInfo {

    @JsonProperty("Folders")
    private List<String> mFolders;

    @JsonCreator
    public ArchiveViewInfoModel(@JsonProperty("FileType") String fileType, @JsonProperty("Pages") List<Page> pages, @JsonProperty("Folders") List<String> folders) {
        super(fileType, pages);
        mFolders = folders;
    }

    @Override
    public List<String> getFolders() {
        return mFolders;
    }

    @Override
    public void setFolders(List<String> folders) {
        this.mFolders = folders;
    }

}
