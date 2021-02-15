package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ProjectManagementViewInfo;

import java.util.Date;
import java.util.List;

public class ProjectManagementViewInfoModel extends ViewInfoModel implements ProjectManagementViewInfo {
    @JsonProperty("StartDate")
    private final Date mStartDate;
    @JsonProperty("EndDate")
    private final Date mEndDate;

    @JsonCreator
    public ProjectManagementViewInfoModel(@JsonProperty("FileType") String fileType, @JsonProperty("Pages") List<Page> pages, @JsonProperty("StartDate") Date startDate, @JsonProperty("EndDate") Date endDate) {
        super(fileType, pages);
        mStartDate = startDate;
        mEndDate = endDate;
    }

    @Override
    public Date getStartDate() {
        return mStartDate;
    }

    @Override
    public Date getEndDate() {
        return mEndDate;
    }
}
