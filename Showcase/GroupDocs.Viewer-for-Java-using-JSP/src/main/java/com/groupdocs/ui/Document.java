package com.groupdocs.ui;
import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;
import com.groupdocs.viewer.licensing.License;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class Document {
    ViewerHtmlHandler viewerHtmlHandler;
    private String filename;
    private int pageNumber;

    public Document() {
        License license = new License();
        if (Files.isReadable(FileSystems.getDefault().getPath(Utils.getProjectProperty("license.path")))) {
            license.setLicense(Utils.getProjectProperty("license.path"));
//            if (!License.isValidLicense()) {
//                throw new RuntimeException("License is not valid");
//            }
        }

        ViewerConfig config = new ViewerConfig();
        config.setStoragePath(Utils.getProjectProperty("storage.path"));

        this.viewerHtmlHandler = new ViewerHtmlHandler(config);
    }

    public int getPageCount() {
        List<PageHtml> pages;
        try {
            pages = viewerHtmlHandler.getPages(filename);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        return pages.size();
    }

    public String getHtmlContent() {
        HtmlOptions options = new HtmlOptions();
        options.setResourcesEmbedded(false);
        options.setPageNumber(this.pageNumber);

        List<PageHtml> pages;
        try {
            pages = this.viewerHtmlHandler.getPages(this.filename, options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        for (PageHtml html : pages) {
            if (this.pageNumber == html.getPageNumber()) {
                return html.getHtmlContent();
            }
        }

        return "No content";
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
