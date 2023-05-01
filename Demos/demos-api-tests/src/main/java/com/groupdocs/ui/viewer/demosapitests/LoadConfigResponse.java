package com.groupdocs.ui.viewer.demosapitests;

import java.util.Objects;

public class LoadConfigResponse {
    private boolean pageSelector;
    private Boolean download;
    private Boolean upload;
    private Boolean print;
    private Boolean browse;
    private Boolean rewrite;
    private Boolean enableRightClick;
    private String filesDirectory;
    private String fontsDirectory;
    private Integer preloadPageCount;
    private Boolean zoom;
    private Boolean search;
    private Boolean thumbnails;
    private Boolean rotate;
    private String defaultDocument;
    private Boolean htmlMode;
    private boolean cache;
    private boolean saveRotateState;
    private String watermarkText;
    private Boolean printAllowed;
    private Boolean showGridLines;
    private String cacheFolderName;

    public boolean isPageSelector() {
        return pageSelector;
    }

    public void setPageSelector(boolean pageSelector) {
        this.pageSelector = pageSelector;
    }

    public Boolean getDownload() {
        return download;
    }

    public void setDownload(Boolean download) {
        this.download = download;
    }

    public Boolean getUpload() {
        return upload;
    }

    public void setUpload(Boolean upload) {
        this.upload = upload;
    }

    public Boolean getPrint() {
        return print;
    }

    public void setPrint(Boolean print) {
        this.print = print;
    }

    public Boolean getBrowse() {
        return browse;
    }

    public void setBrowse(Boolean browse) {
        this.browse = browse;
    }

    public Boolean getRewrite() {
        return rewrite;
    }

    public void setRewrite(Boolean rewrite) {
        this.rewrite = rewrite;
    }

    public Boolean getEnableRightClick() {
        return enableRightClick;
    }

    public void setEnableRightClick(Boolean enableRightClick) {
        this.enableRightClick = enableRightClick;
    }

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
    }

    public String getFontsDirectory() {
        return fontsDirectory;
    }

    public void setFontsDirectory(String fontsDirectory) {
        this.fontsDirectory = fontsDirectory;
    }

    public Integer getPreloadPageCount() {
        return preloadPageCount;
    }

    public void setPreloadPageCount(Integer preloadPageCount) {
        this.preloadPageCount = preloadPageCount;
    }

    public Boolean getZoom() {
        return zoom;
    }

    public void setZoom(Boolean zoom) {
        this.zoom = zoom;
    }

    public Boolean getSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    public Boolean getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Boolean thumbnails) {
        this.thumbnails = thumbnails;
    }

    public Boolean getRotate() {
        return rotate;
    }

    public void setRotate(Boolean rotate) {
        this.rotate = rotate;
    }

    public String getDefaultDocument() {
        return defaultDocument;
    }

    public void setDefaultDocument(String defaultDocument) {
        this.defaultDocument = defaultDocument;
    }

    public Boolean getHtmlMode() {
        return htmlMode;
    }

    public void setHtmlMode(Boolean htmlMode) {
        this.htmlMode = htmlMode;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public boolean isSaveRotateState() {
        return saveRotateState;
    }

    public void setSaveRotateState(boolean saveRotateState) {
        this.saveRotateState = saveRotateState;
    }

    public String getWatermarkText() {
        return watermarkText;
    }

    public void setWatermarkText(String watermarkText) {
        this.watermarkText = watermarkText;
    }

    public Boolean getPrintAllowed() {
        return printAllowed;
    }

    public void setPrintAllowed(Boolean printAllowed) {
        this.printAllowed = printAllowed;
    }

    public Boolean getShowGridLines() {
        return showGridLines;
    }

    public void setShowGridLines(Boolean showGridLines) {
        this.showGridLines = showGridLines;
    }

    public String getCacheFolderName() {
        return cacheFolderName;
    }

    public void setCacheFolderName(String cacheFolderName) {
        this.cacheFolderName = cacheFolderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoadConfigResponse that = (LoadConfigResponse) o;
        return pageSelector == that.pageSelector && cache == that.cache && saveRotateState == that.saveRotateState && Objects.equals(download, that.download) && Objects.equals(upload, that.upload) && Objects.equals(print, that.print) && Objects.equals(browse, that.browse) && Objects.equals(rewrite, that.rewrite) && Objects.equals(enableRightClick, that.enableRightClick) && Objects.equals(filesDirectory, that.filesDirectory) && Objects.equals(fontsDirectory, that.fontsDirectory) && Objects.equals(preloadPageCount, that.preloadPageCount) && Objects.equals(zoom, that.zoom) && Objects.equals(search, that.search) && Objects.equals(thumbnails, that.thumbnails) && Objects.equals(rotate, that.rotate) && Objects.equals(defaultDocument, that.defaultDocument) && Objects.equals(htmlMode, that.htmlMode) && Objects.equals(watermarkText, that.watermarkText) && Objects.equals(printAllowed, that.printAllowed) && Objects.equals(showGridLines, that.showGridLines) && Objects.equals(cacheFolderName, that.cacheFolderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageSelector, download, upload, print, browse, rewrite, enableRightClick, filesDirectory, fontsDirectory, preloadPageCount, zoom, search, thumbnails, rotate, defaultDocument, htmlMode, cache, saveRotateState, watermarkText, printAllowed, showGridLines, cacheFolderName);
    }

    @Override
    public String toString() {
        return "LoadConfig{" +
                "pageSelector=" + pageSelector +
                ", download=" + download +
                ", upload=" + upload +
                ", print=" + print +
                ", browse=" + browse +
                ", rewrite=" + rewrite +
                ", enableRightClick=" + enableRightClick +
                ", filesDirectory='" + filesDirectory + '\'' +
                ", fontsDirectory='" + fontsDirectory + '\'' +
                ", preloadPageCount=" + preloadPageCount +
                ", zoom=" + zoom +
                ", search=" + search +
                ", thumbnails=" + thumbnails +
                ", rotate=" + rotate +
                ", defaultDocument='" + defaultDocument + '\'' +
                ", htmlMode=" + htmlMode +
                ", cache=" + cache +
                ", saveRotateState=" + saveRotateState +
                ", watermarkText='" + watermarkText + '\'' +
                ", printAllowed=" + printAllowed +
                ", showGridLines=" + showGridLines +
                ", cacheFolderName='" + cacheFolderName + '\'' +
                '}';
    }
}
