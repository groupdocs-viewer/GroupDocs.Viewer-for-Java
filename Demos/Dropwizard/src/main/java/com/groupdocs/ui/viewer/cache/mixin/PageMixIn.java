package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Line;

import java.util.List;

public abstract class PageMixIn {
    PageMixIn(@JsonProperty("number") int number, @JsonProperty("visible") boolean visible, @JsonProperty("width") int width, @JsonProperty("height") int height, @JsonProperty("lines") List<Line> lines) {
    }
}
