package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Character;

public abstract class WordMixIn {
    WordMixIn(@JsonProperty("word") String word, @JsonProperty("x") double x, @JsonProperty("y") double y, @JsonProperty("width") double width, @JsonProperty("height") double height, @JsonProperty("characters") java.util.List<Character> characters) {
    }
}
