package com.groupdocs.ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * CommonConfiguration
 *
 * @author Aspose Pty Ltd
 */
@Component
public class CommonConfiguration {

    @Value("#{new Boolean('${common.pageSelector}')}")
    private boolean pageSelector;

    @Value("#{new Boolean('${common.download}')}")
    private Boolean download;

    @Value("#{new Boolean('${common.upload}')}")
    private Boolean upload;

    @Value("#{new Boolean('${common.print}')}")
    private Boolean print;

    @Value("#{new Boolean('${common.browse}')}")
    private Boolean browse;

    @Value("#{new Boolean('${common.rewrite}')}")
    private Boolean rewrite;

    @Value("#{new Boolean('${common.enableRightClick}')}")
    private Boolean enableRightClick;

    public boolean isPageSelector() {
        return pageSelector;
    }

    public void setPageSelector(boolean pageSelector) {
        this.pageSelector = pageSelector;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public boolean isUpload() {
        return upload;
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public boolean isBrowse() {
        return browse;
    }

    public void setBrowse(boolean browse) {
        this.browse = browse;
    }

    public boolean isRewrite() {
        return rewrite;
    }

    public void setRewrite(boolean rewrite) {
        this.rewrite = rewrite;
    }

    public Boolean getEnableRightClick() {
        return enableRightClick;
    }

    public void setEnableRightClick(Boolean enableRightClick) {
        this.enableRightClick = enableRightClick;
    }

    @Override
    public String toString() {
        return "CommonConfiguration{" +
                "pageSelector=" + pageSelector +
                ", download=" + download +
                ", upload=" + upload +
                ", print=" + print +
                ", browse=" + browse +
                ", rewrite=" + rewrite +
                ", enableRightClick=" + enableRightClick +
                '}';
    }
}
