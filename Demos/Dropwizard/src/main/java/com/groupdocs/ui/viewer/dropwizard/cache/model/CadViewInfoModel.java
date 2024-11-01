package com.groupdocs.ui.viewer.dropwizard.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.CadViewInfo;
import com.groupdocs.viewer.results.Layer;
import com.groupdocs.viewer.results.Layout;
import com.groupdocs.viewer.results.Page;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class CadViewInfoModel extends ViewInfoModel implements CadViewInfo {
    @JsonProperty("Layers")
    private List<Layer> mLayers;
    @JsonProperty("Layouts")
    private List<Layout> mLayouts;

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

    @Override
    public void setLayers(List<Layer> layers) {
        this.mLayers = layers;
    }

    @Override
    public void setLayouts(List<Layout> layouts) {
        this.mLayouts = layouts;
    }
}
