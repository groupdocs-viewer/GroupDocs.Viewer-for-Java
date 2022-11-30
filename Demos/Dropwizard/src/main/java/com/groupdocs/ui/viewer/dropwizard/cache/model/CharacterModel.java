package com.groupdocs.ui.viewer.dropwizard.cache.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.Character;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class CharacterModel implements Character {
    @JsonProperty("Value")
    private final java.lang.Character mValue;
    @JsonProperty("X")
    private final double mX;
    @JsonProperty("Y")
    private final double mY;
    @JsonProperty("Width")
    private final double mWidth;
    @JsonProperty("Height")
    private final double mHeight;

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
}
