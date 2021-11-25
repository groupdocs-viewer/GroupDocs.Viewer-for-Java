package com.groupdocs.ui.viewer.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.OutlookViewInfo;
import com.groupdocs.viewer.results.Page;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
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
