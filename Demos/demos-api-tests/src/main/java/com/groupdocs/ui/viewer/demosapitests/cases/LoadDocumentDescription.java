package com.groupdocs.ui.viewer.demosapitests.cases;

import java.util.ArrayList;
import java.util.List;

public class LoadDocumentDescription {
    private String guid;
    private List<PageDescriptionEntity> pages = new ArrayList<>();
    private Boolean printAllowed;
    private boolean showGridLines;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public List<PageDescriptionEntity> getPages() {
        return pages;
    }

    public void setPages(List<PageDescriptionEntity> pages) {
        this.pages = pages;
    }

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

    public static class PageDescriptionEntity {
        private String data;
        private int angle;
        private double width;
        private double height;
        private int number;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getAngle() {
            return angle;
        }

        public void setAngle(int angle) {
            this.angle = angle;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
