package com.groupdocs.examples.viewer.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.Word;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class WordModel implements Word {
    @JsonProperty("Characters")
    private List<Character> mCharacters;
    @JsonProperty("Value")
    private String mValue;
    @JsonProperty("X")
    private double mX;
    @JsonProperty("Y")
    private double mY;
    @JsonProperty("Width")
    private double mWidth;
    @JsonProperty("Height")
    private double mHeight;

    @JsonCreator
    public WordModel(@JsonProperty("Value") String word, @JsonProperty("X") double x, @JsonProperty("Y") double y, @JsonProperty("Width") double width, @JsonProperty("Height") double height, @JsonProperty("Characters") List<Character> characters) {
        mValue = word;
        mX = x;
        mY = y;
        mWidth = width;
        mHeight = height;
        mCharacters = characters;
    }

    @Override
    public List<Character> getCharacters() {
        return mCharacters;
    }

    @Override
    public String getValue() {
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

    @Override
    public void setCharacters(List<Character> characters) {
        this.mCharacters = characters;
    }

    @Override
    public void setValue(String value) {
        this.mValue = value;
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
