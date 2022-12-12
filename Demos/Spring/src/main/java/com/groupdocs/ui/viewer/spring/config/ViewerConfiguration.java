package com.groupdocs.ui.viewer.spring.config;

import com.groupdocs.ui.viewer.spring.common.config.CommonConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;

import static com.groupdocs.ui.viewer.spring.config.DefaultDirectories.defaultViewerDirectory;
import static com.groupdocs.ui.viewer.spring.config.DefaultDirectories.relativePathToAbsolute;

@Component
public class ViewerConfiguration extends CommonConfiguration {

    @Value("${viewer.filesDirectory}")
    private String filesDirectory;

    @Value("${viewer.fontsDirectory}")
    private String fontsDirectory;

    @Value("#{new Integer('${viewer.preloadPageCount}')}")
    private Integer preloadPageCount;

    @Value("#{new Boolean('${viewer.zoom}')}")
    private Boolean zoom;

    @Value("#{new Boolean('${viewer.search}')}")
    private Boolean search;

    @Value("#{new Boolean('${viewer.thumbnails}')}")
    private Boolean thumbnails;

    @Value("#{new Boolean('${viewer.rotate}')}")
    private Boolean rotate;

    @Value("${viewer.defaultDocument}")
    private String defaultDocument;

    @Value("#{new Boolean('${viewer.htmlMode}')}")
    private Boolean htmlMode;

    @Value("#{new Boolean('${viewer.cache}')}")
    private boolean cache;

    @Value("#{new Boolean('${viewer.saveRotateState}')}")
    private boolean saveRotateState = true;

    @Value("${viewer.watermarkText}")
    private String watermarkText;

    @Value("#{new Boolean('${viewer.printAllowed}')}")
    private Boolean printAllowed;

    @Value("#{new Boolean('${viewer.showGridLines}')}")
    private Boolean showGridLines;

    @Value("${viewer.cacheFolderName}")
    private String cacheFolderName;

    @PostConstruct
    public void init() {
        this.filesDirectory = StringUtils.isEmpty(this.filesDirectory) ? defaultViewerDirectory() : relativePathToAbsolute(this.filesDirectory);
    }

    public String getFilesDirectory() {
        if (!StringUtils.isEmpty(filesDirectory) && !filesDirectory.endsWith(File.separator)) {
            return filesDirectory + File.separator;
        }
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

    public Boolean isZoom() {
        return zoom;
    }

    public void setZoom(Boolean zoom) {
        this.zoom = zoom;
    }

    public Boolean isSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    public Boolean isThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Boolean thumbnails) {
        this.thumbnails = thumbnails;
    }

    public Boolean isRotate() {
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

    public Boolean isHtmlMode() {
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
    public String toString() {
        return "ViewerConfiguration{" +
                "filesDirectory='" + filesDirectory + '\'' +
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
                ", cacheFolderName=" + cacheFolderName +
                '}';
    }
}
