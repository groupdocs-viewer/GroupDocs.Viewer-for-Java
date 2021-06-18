package com.groupdocs.ui.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class LayoutMixIn {
    LayoutMixIn(@JsonProperty("name") String name, @JsonProperty("width") double width, @JsonProperty("height") double height) {
    }
}
