package com.groupdocs.ui.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Character;
import com.groupdocs.viewer.results.Word;

import java.util.List;

public abstract class WordMixIn {
    WordMixIn(@JsonProperty("word") String word, @JsonProperty("x") double x, @JsonProperty("y") double y, @JsonProperty("width") double width, @JsonProperty("height") double height, @JsonProperty("characters") List<Character> characters) {
    }
}
