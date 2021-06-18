package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class LayerMixIn {
    LayerMixIn(@JsonProperty("name") String name, @JsonProperty("visible") boolean visible) {
    }
}
