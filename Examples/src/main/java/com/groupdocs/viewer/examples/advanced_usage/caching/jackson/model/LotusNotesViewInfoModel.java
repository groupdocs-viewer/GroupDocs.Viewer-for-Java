package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.LotusNotesViewInfo;
import com.groupdocs.viewer.results.Page;

import java.util.List;

public class LotusNotesViewInfoModel extends ViewInfoModel implements LotusNotesViewInfo {
    @JsonProperty("NotesCount")
    private final int mNotesCount;

    @JsonCreator
    public LotusNotesViewInfoModel(@JsonProperty("FileType") String fileType, @JsonProperty("Pages") List<Page> pages, @JsonProperty("NotesCount") int notesCount) {
        super(fileType, pages);
        mNotesCount = notesCount;
    }

    @Override
    public int getNotesCount() {
        return mNotesCount;
    }
}
