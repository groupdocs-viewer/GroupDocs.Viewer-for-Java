package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.Character;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class CharacterModel implements Character {
    @JsonProperty("Value")
    private java.lang.Character mValue;
    @JsonProperty("X")
    private double mX;
    @JsonProperty("Y")
    private double mY;
    @JsonProperty("Width")
    private double mWidth;
    @JsonProperty("Height")
    private double mHeight;

    @JsonCreator
    public CharacterModel(@JsonProperty("Value") char character, @JsonProperty("X") double x, @JsonProperty("Y") double y, @JsonProperty("Width") double width, @JsonProperty("Height") double height) {
        mValue = character;
        mX = x;
        mY = y;
        mWidth = width;
        mHeight = height;
    }

    @Override
    public java.lang.Character getValue() {
        return mValue;
    }

    @Override
    public void setValue(java.lang.Character value) {
        this.mValue = value;

    }

    @Override
    public double getX() {
        return mX;
    }

    @Override
    public double getY() {
        return mY;
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
    public void setX(double x) {
        this.mX = x;
    }

    @Override
    public void setY(double y) {
        this.mY = y;
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
