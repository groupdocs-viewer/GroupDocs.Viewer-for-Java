package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Layer;

public class LayerModel implements Layer {
    @JsonProperty("Name")
    private final String mName;
    @JsonProperty("Visible")
    private boolean mVisible;

    @JsonCreator
    public LayerModel(@JsonProperty("Name") String name, @JsonProperty("Visible") boolean visible) {
        mName = name;
        mVisible = visible;
    }

    public LayerModel(String name) {
        mName = name;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public boolean isVisible() {
        return mVisible;
    }
}
