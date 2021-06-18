package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Word;

public abstract class LineMixIn {
    LineMixIn(@JsonProperty("line") String line, @JsonProperty("x") double x, @JsonProperty("y") double y, @JsonProperty("width") double width, @JsonProperty("height") double height, @JsonProperty("words") java.util.List<Word> words) {
    }
}
