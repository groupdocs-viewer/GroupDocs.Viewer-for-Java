package com.groupdocs.ui.viewer.spring.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.Line;
import com.groupdocs.viewer.results.Word;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class LineModel implements Line {
    @JsonProperty("X")
    private final double mX;
    @JsonProperty("Y")
    private final double mY;
    @JsonProperty("Width")
    private final double mWidth;
    @JsonProperty("Height")
    private final double mHeight;
    @JsonProperty("Value")
    private final String mLine;
    @JsonProperty("Words")
    private final List<Word> mWords;

    @JsonCreator
    public LineModel(@JsonProperty("Line") String line, @JsonProperty("X") double x, @JsonProperty("Y") double y, @JsonProperty("Width") double width, @JsonProperty("Height") double height, @JsonProperty("Words") List<Word> words) {
        this.mX = x;
        this.mY = y;
        this.mWidth = width;
        this.mHeight = height;
        this.mLine = line;
        this.mWords = words;
    }

    @Override
    public List<Word> getWords() {
        return mWords;
    }

    @Override
    public String getValue() {
        return mLine;
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
