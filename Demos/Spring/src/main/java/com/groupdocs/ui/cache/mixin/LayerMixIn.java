package com.groupdocs.ui.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.results.Line;

import java.util.List;

public abstract class LayerMixIn {
    LayerMixIn(@JsonProperty("name") String name, @JsonProperty("visible") boolean visible) {
    }
}
