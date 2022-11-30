package com.groupdocs.ui.viewer.spring.common.entity.web;

import java.util.ArrayList;
import java.util.List;

public class LoadDocumentEntity {

    private String guid;
    private List<PageDescriptionEntity> pages = new ArrayList<>();
    private Boolean printAllowed = true;
    private boolean showGridLines = true;

    /**
     * Document Guid
     */
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * list of pages
     */
    public List<PageDescriptionEntity> getPages() {
        return pages;
    }

    public void setPages(List<PageDescriptionEntity> pages) {
        this.pages = pages;
    }

    /**
     * Restriction for printing pdf files in viewer
     */
    public Boolean getPrintAllowed() {
        return printAllowed;
    }

    public void setPrintAllowed(Boolean printAllowed) {
        this.printAllowed = printAllowed;
    }

    public boolean isShowGridLines() {
        return showGridLines;
    }

    public void setShowGridLines(boolean showGridLines) {
        this.showGridLines = showGridLines;
    }
}
