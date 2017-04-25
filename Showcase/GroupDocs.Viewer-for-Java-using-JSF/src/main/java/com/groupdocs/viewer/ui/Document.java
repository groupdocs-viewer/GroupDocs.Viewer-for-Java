package com.groupdocs.viewer.ui;

import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.containers.FileContainer;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.domain.options.PdfFileOptions;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Named("document")
@ViewScoped
public class Document implements Serializable {
    Path tmp;

    @Inject
    Pager pager;

    @Inject
    private Loader loader;

    private ViewerHtmlHandler viewerHtmlHandler;

    @PostConstruct
    private void init() {
        try {
            tmp = Files.createTempDirectory("groupdocs-viewer");
        } catch (IOException x) {
            throw new RuntimeException(x);
        }

        ViewerConfig config = new ViewerConfig();
        config.setTempPath(tmp.toString());
        config.setCachePath(tmp.toString());
        config.setStoragePath(Utils.getStoragePath().toString());

        this.viewerHtmlHandler = new ViewerHtmlHandler(config);
    }

    public ViewerHtmlHandler getViewerHtmlHandler() {
        return this.viewerHtmlHandler;
    }

    public List<PageHtml> getPages() {
        HtmlOptions options = new HtmlOptions();
        options.setResourcesEmbedded(true);

        List<PageHtml> pages = null;
        try (InputStream i = loader.getInputStream()) {
            pages = viewerHtmlHandler.getPages(i, options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
        return pages;
    }

    public PageHtml getPageHtml() {
        HtmlOptions options = new HtmlOptions();
        options.setResourcesEmbedded(true);
        options.setPageNumber(pager.getCurrent());

        List<PageHtml> pages = null;
        try (InputStream i = loader.getInputStream()) {
            pages = viewerHtmlHandler.getPages(i, loader.getGuid(), options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        for (PageHtml page : pages) {
            // The collection will always contain one object because
            // we have request only one page at a time.
            if (page.getPageNumber() == pager.getCurrent()) {
                return page;
            }
        }

        return null;
    }

    public int getPageCount() {
        List<PageHtml> list;
        try (InputStream i = loader.getInputStream()) {
            list = viewerHtmlHandler.getPages(i, loader.getGuid());
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        return list.size();
    }

    public StreamedContent getOriginal() {
        return new DefaultStreamedContent(loader.getInputStream(), "application/octet-stream", loader.getGuid());
    }

    public StreamedContent getPdf() throws Throwable {
        PdfFileOptions o = new PdfFileOptions();
        o.setGuid(loader.getGuid());

        FileContainer fc = viewerHtmlHandler.getPdfFile(o);
        return new DefaultStreamedContent(fc.getStream(), "application/pdf", "document.pdf");

    }
}

