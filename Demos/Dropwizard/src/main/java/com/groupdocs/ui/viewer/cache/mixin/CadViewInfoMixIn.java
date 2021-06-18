package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.Layer;
import com.groupdocs.viewer.results.Layout;
import com.groupdocs.viewer.results.Page;

public abstract class CadViewInfoMixIn {
    CadViewInfoMixIn(@JsonProperty("fileType") FileType fileType, @JsonProperty("pages") java.util.List<Page> pages, @JsonProperty("layers") java.util.List<Layer> layers, @JsonProperty("layouts") java.util.List<Layout> layouts) {
    }
}
