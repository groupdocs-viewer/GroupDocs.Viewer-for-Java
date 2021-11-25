package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Layout;

public class LayoutModel implements Layout {
    @JsonProperty("Name")
    private final String mName;
    @JsonProperty("Width")
    private final double mWidth;
    @JsonProperty("Height")
    private final double mHeight;

    @JsonCreator
    public LayoutModel(@JsonProperty("Name") String name, @JsonProperty("Width") double width, @JsonProperty("Height") double height) {
        mName = name;
        mWidth = width;
        mHeight = height;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public double getWidth() {
        return mWidth;
    }

    @Override
    public double getHeight() {
        return mHeight;
    }
}
