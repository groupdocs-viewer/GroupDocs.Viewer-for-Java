package com.groupdocs.ui.viewer.spring.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ProjectManagementViewInfo;

import java.util.Date;
import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class ProjectManagementViewInfoModel extends ViewInfoModel implements ProjectManagementViewInfo {
    @JsonProperty("StartDate")
    private Date mStartDate;
    @JsonProperty("EndDate")
    private Date mEndDate;

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

    @Override
    public void setStartDate(Date startDate) {
        this.mStartDate = startDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.mEndDate = endDate;
    }
}
