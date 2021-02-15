package com.groupdocs.viewer.examples.advanced_usage.caching.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.Word;

import java.util.List;

public class WordModel implements Word {
    @JsonProperty("Characters")
    private final List<Character> mCharacters;
    @JsonProperty("Value")
    private final String mValue;
    @JsonProperty("X")
    private final double mX;
    @JsonProperty("Y")
    private final double mY;
    @JsonProperty("Width")
    private final double mWidth;
    @JsonProperty("Height")
    private final double mHeight;

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
}
