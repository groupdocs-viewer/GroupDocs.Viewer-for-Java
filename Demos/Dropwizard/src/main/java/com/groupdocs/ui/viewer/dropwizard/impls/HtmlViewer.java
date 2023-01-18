package com.groupdocs.ui.viewer.dropwizard.impls;

import com.groupdocs.ui.viewer.dropwizard.cache.ViewerCache;
import com.groupdocs.ui.viewer.dropwizard.factory.CustomFileStreamFactory;
import com.groupdocs.ui.viewer.dropwizard.factory.CustomPageStreamFactory;
import com.groupdocs.ui.viewer.dropwizard.factory.CustomResourceStreamFactory;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.Page;

import java.nio.file.Paths;
import java.util.List;

public class HtmlViewer extends CustomViewer<HtmlViewOptions> {
    public static final String CACHE_PAGES_EXTENSION = ".html";

    public HtmlViewer(String filePath, ViewerCache cache, LoadOptions loadOptions) {
        this(filePath, cache, loadOptions, -1, 0);
    }

    public HtmlViewer(String filePath, ViewerCache cache, LoadOptions loadOptions, int pageNumber/* = -1*/, int newAngle/* = 0*/) {
        super(filePath, cache, loadOptions);
        this.viewOptions = this.createHtmlViewOptions(pageNumber, newAngle);
        this.pdfViewOptions = this.createPdfViewOptions();
        this.viewInfoOptions = ViewInfoOptions.fromHtmlViewOptions(this.viewOptions);
    }

    private com.groupdocs.viewer.options.HtmlViewOptions createHtmlViewOptions(int passedPageNumber/* = -1*/, int newAngle/* = 0*/) {
        HtmlViewOptions htmlViewOptions = HtmlViewOptions.forExternalResources(
                new CustomPageStreamFactory(this.cache, CACHE_PAGES_EXTENSION),
                new CustomResourceStreamFactory(cache, Paths.get(filePath).getFileName().toString()));

        htmlViewOptions.getSpreadsheetOptions().setTextOverflowMode(TextOverflowMode.HIDE_TEXT);
        htmlViewOptions.getSpreadsheetOptions().setSkipEmptyColumns(true);
        htmlViewOptions.getSpreadsheetOptions().setSkipEmptyRows(true);
        setWatermarkOptions(htmlViewOptions);

        setCommonViewOptions(htmlViewOptions);

        if (passedPageNumber >= 0 && newAngle != 0) {
            Rotation rotationAngle = getRotationByAngle(newAngle);
            htmlViewOptions.rotatePage(passedPageNumber, rotationAngle);
        }

        return htmlViewOptions;
    }

    private com.groupdocs.viewer.options.PdfViewOptions createPdfViewOptions() {
        PdfViewOptions pdfViewOptions = new PdfViewOptions(new CustomFileStreamFactory(this.cache, ".pdf"));
        setCommonViewOptions(pdfViewOptions);
        return pdfViewOptions;
    }

    private void setCommonViewOptions(com.groupdocs.viewer.options.ViewOptions viewOptions) {
        viewOptions.getSpreadsheetOptions().setTextOverflowMode(TextOverflowMode.HIDE_TEXT);
        viewOptions.getSpreadsheetOptions().setSkipEmptyColumns(true);
        viewOptions.getSpreadsheetOptions().setSkipEmptyRows(true);
        setWatermarkOptions(viewOptions);
    }

    @Override
    protected int[] getPagesMissingFromCache(List<Page> pages) {
        return super.getPagesMissingFromCache(pages, CACHE_PAGES_EXTENSION);
    }
}