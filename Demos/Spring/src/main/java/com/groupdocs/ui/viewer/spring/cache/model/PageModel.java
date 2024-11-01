package com.groupdocs.ui.viewer.spring.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.Line;
import com.groupdocs.viewer.results.Page;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class PageModel implements Page {
    @JsonProperty("Name")
    private String mName;
    @JsonProperty("Number")
    private int mNumber;
    @JsonProperty("Visible")
    private boolean mVisible;
    @JsonProperty("Width")
    private int mWidth;
    @JsonProperty("Height")
    private int mHeight;
    @JsonProperty("Lines")
    private List<Line> mLines;

    public PageModel(@JsonProperty("Number") int number, @JsonProperty("Name") String name, @JsonProperty("Visible") boolean visible) {
        mName = name;
        mNumber = number;
        mVisible = visible;
    }

    public PageModel(@JsonProperty("Number") int number, @JsonProperty("Name") String name, @JsonProperty("Visible") boolean visible, @JsonProperty("Width") int width, @JsonProperty("Height") int height) {
        mName = name;
        mNumber = number;
        mVisible = visible;
        mWidth = width;
        mHeight = height;
    }

    @JsonCreator
    public PageModel(@JsonProperty("Number") int number, @JsonProperty("Name") String name, @JsonProperty("Visible") boolean visible, @JsonProperty("Width") int width, @JsonProperty("Height") int height, @JsonProperty("Lines") List<Line> lines) {
        mName = name;
        mNumber = number;
        mVisible = visible;
        mWidth = width;
        mHeight = height;
        mLines = lines;
    }

    public PageModel(@JsonProperty("Number") int number, @JsonProperty("Visible") boolean visible, @JsonProperty("Width") int width, @JsonProperty("Height") int height) {
        mNumber = number;
        mVisible = visible;
        mWidth = width;
        mHeight = height;
    }

    public PageModel(@JsonProperty("Number") int number, @JsonProperty("Visible") boolean visible, @JsonProperty("Width") int width, @JsonProperty("Height") int height, @JsonProperty("Lines") List<Line> lines) {
        mNumber = number;
        mVisible = visible;
        mWidth = width;
        mHeight = height;
        mLines = lines;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public int getNumber() {
        return mNumber;
    }

    @Override
    public boolean isVisible() {
        return mVisible;
    }

    @Override
    public int getWidth() {
        return mWidth;
    }

    @Override
    public int getHeight() {
        return mHeight;
    }

    @Override
    public List<Line> getLines() {
        return mLines;
    }

    @Override
    public void setName(String name) {
        this.mName = name;
    }

    @Override
    public void setNumber(int number) {
        this.mNumber = number;
    }

    @Override
    public void setVisible(boolean visible) {
        this.mVisible = visible;
    }

    @Override
    public void setWidth(int width) {
        this.mWidth = width;
    }

    @Override
    public void setHeight(int height) {
        this.mHeight = height;
    }

    @Override
    public void setLines(List<Line> lines) {
        this.mLines = lines;
    }
}
