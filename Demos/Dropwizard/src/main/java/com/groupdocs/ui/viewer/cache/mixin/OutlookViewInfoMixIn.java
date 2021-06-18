package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.Page;

public abstract class OutlookViewInfoMixIn {
    OutlookViewInfoMixIn(@JsonProperty("fileType") FileType fileType, @JsonProperty("pages") java.util.List<Page> pages, @JsonProperty("folders") java.util.List<String> folders) {
    }

}
