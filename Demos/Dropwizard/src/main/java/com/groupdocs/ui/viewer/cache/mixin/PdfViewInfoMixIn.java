package com.groupdocs.ui.viewer.cache.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.results.Page;

import java.util.List;

public abstract class PdfViewInfoMixIn {
    PdfViewInfoMixIn(@JsonProperty("fileType") FileType fileType, @JsonProperty("pages") List<Page> pages, @JsonProperty("printingAllowed") boolean printingAllowed) {
    }
}
