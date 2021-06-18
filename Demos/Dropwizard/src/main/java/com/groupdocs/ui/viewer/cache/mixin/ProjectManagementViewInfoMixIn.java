package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.Page;

public abstract class ProjectManagementViewInfoMixIn {
    ProjectManagementViewInfoMixIn(@JsonProperty("fileType") FileType fileType, @JsonProperty("pages") java.util.List<Page> pages, @JsonProperty("startDate") java.util.Date startDate, @JsonProperty("endDate") java.util.Date endDate) {
    }
}
