package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class CharacterMixIn {
    CharacterMixIn(@JsonProperty("character") char character, @JsonProperty("x") double x, @JsonProperty("y") double y, @JsonProperty("width") double width, @JsonProperty("height") double height) {
    }
}
