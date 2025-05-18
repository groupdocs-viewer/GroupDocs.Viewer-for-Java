package com.groupdocs.examples.viewer.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.Layout;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class LayoutModel implements Layout {
    @JsonProperty("Name")
    private String mName;
    @JsonProperty("Width")
    private double mWidth;
    @JsonProperty("Height")
    private double mHeight;

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

    @Override
    public void setName(String name) {
        this.mName = name;
    }

    @Override
    public void setWidth(double width) {
        this.mWidth = width;
    }

    @Override
    public void setHeight(double height) {
        this.mHeight = height;
    }
}
