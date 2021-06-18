package com.groupdocs.ui.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Character;

import java.util.List;

public abstract class CharacterMixIn {
    CharacterMixIn(@JsonProperty("character") char character, @JsonProperty("x") double x, @JsonProperty("y") double y, @JsonProperty("width") double width, @JsonProperty("height") double height) {
    }
}
