package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.OutlookViewInfo;
import com.groupdocs.viewer.results.Page;

import java.util.List;

public class OutlookViewInfoModel extends ViewInfoModel implements OutlookViewInfo {
    @JsonProperty("Folders")
    private final List<String> mFolders;

    @JsonCreator
    public OutlookViewInfoModel(@JsonProperty("FileType") String fileType, @JsonProperty("Pages") List<Page> pages, @JsonProperty("Folders") List<String> folders) {
        super(fileType, pages);
        mFolders = folders;
    }

    @Override
    public List<String> getFolders() {
        return mFolders;
    }
}
