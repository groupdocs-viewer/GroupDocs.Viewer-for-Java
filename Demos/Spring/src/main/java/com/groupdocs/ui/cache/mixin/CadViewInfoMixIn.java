package com.groupdocs.ui.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.Layer;
import com.groupdocs.viewer.results.Layout;
import com.groupdocs.viewer.results.Page;

import java.util.List;

public abstract class CadViewInfoMixIn {
    CadViewInfoMixIn(@JsonProperty("fileType") FileType fileType, @JsonProperty("pages") List<Page> pages, @JsonProperty("layers") List<Layer> layers, @JsonProperty("layouts") List<Layout> layouts) {
    }

}
