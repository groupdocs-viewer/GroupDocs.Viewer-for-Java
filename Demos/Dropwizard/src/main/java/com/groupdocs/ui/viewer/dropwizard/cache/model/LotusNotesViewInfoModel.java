package com.groupdocs.ui.viewer.dropwizard.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.LotusNotesViewInfo;
import com.groupdocs.viewer.results.Page;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
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
