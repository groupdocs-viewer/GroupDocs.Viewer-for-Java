package com.groupdocs.ui.viewer.dropwizard.cache.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.PdfViewInfo;

import java.util.List;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class PdfViewInfoModel extends ViewInfoModel implements PdfViewInfo {

    @JsonProperty("PrintingAllowed")
    private boolean mPrintingAllowed;

    @JsonCreator
    public PdfViewInfoModel(@JsonProperty("FileType") String fileType, @JsonProperty("Pages") List<Page> pages, @JsonProperty("PrintingAllowed") boolean printingAllowed) {
        super(fileType, pages);
        mPrintingAllowed = printingAllowed;
    }

    @Override
    public boolean isPrintingAllowed() {
        return mPrintingAllowed;
    }

    @Override
    public void setPrintingAllowed(boolean printingAllowed) {
        this.mPrintingAllowed = printingAllowed;
    }
}
