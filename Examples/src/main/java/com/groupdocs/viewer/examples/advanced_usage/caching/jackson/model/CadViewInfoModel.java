package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.CadViewInfo;
import com.groupdocs.viewer.results.Layer;
import com.groupdocs.viewer.results.Layout;
import com.groupdocs.viewer.results.Page;

import java.util.List;

public class CadViewInfoModel extends ViewInfoModel implements CadViewInfo {
    @JsonProperty("Layers")
    private final List<Layer> mLayers;
    @JsonProperty("Layouts")
    private final List<Layout> mLayouts;

    @JsonCreator
    public CadViewInfoModel(@JsonProperty("FileType") String fileType, @JsonProperty("Pages") List<Page> pages, @JsonProperty("Layers") List<Layer> layers, @JsonProperty("Layouts") List<Layout> layouts) {
        super(fileType, pages);
        mLayers = layers;
        mLayouts = layouts;
    }

    @Override
    public List<Layer> getLayers() {
        return mLayers;
    }

    @Override
    public List<Layout> getLayouts() {
        return mLayouts;
    }
}
