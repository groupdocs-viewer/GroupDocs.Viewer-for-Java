package com.groupdocs.ui.viewer.spring.impls;

import com.groupdocs.ui.viewer.spring.cache.ViewerCache;
import com.groupdocs.ui.viewer.spring.factory.CustomFileStreamFactory;
import com.groupdocs.ui.viewer.spring.factory.CustomPageStreamFactory;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.Page;

import java.util.List;

public class PngViewer extends CustomViewer<PngViewOptions> {
    public static final String CACHE_PAGES_EXTENSION = ".png";
    private CustomFileStreamFactory customFileStreamFactory;

    public PngViewer(String filePath, ViewerCache cache, LoadOptions loadOptions) {
        this(filePath, cache, loadOptions, -1, 0);
    }

    public PngViewer(String filePath, ViewerCache cache, LoadOptions loadOptions, int pageNumber/* = -1*/, int newAngle/* = 0*/) {
        super(filePath, cache, loadOptions);
        this.viewOptions = this.createPngViewOptions(pageNumber, newAngle);
        this.pdfViewOptions = this.createPdfViewOptions();
        this.viewInfoOptions = ViewInfoOptions.fromPngViewOptions(this.viewOptions);
    }

    private PngViewOptions createPngViewOptions(int passedPageNumber/* = -1*/, int newAngle/* = 0*/) {
        PngViewOptions createdPngViewOptions = new PngViewOptions(new CustomPageStreamFactory(this.cache, CACHE_PAGES_EXTENSION));

        if (passedPageNumber >= 0 && newAngle != 0) {
            Rotation rotationAngle = getRotationByAngle(newAngle);
            createdPngViewOptions.rotatePage(passedPageNumber, rotationAngle);
        }

        setWatermarkOptions(createdPngViewOptions);

        return createdPngViewOptions;
    }

    private com.groupdocs.viewer.options.PdfViewOptions createPdfViewOptions() {
        this.customFileStreamFactory = new CustomFileStreamFactory(this.cache, ".pdf");
        PdfViewOptions pdfViewOptions = new PdfViewOptions(customFileStreamFactory);
        setWatermarkOptions(pdfViewOptions);
        return pdfViewOptions;
    }

    @Override
    protected int[] getPagesMissingFromCache(List<Page> pages) {
        return super.getPagesMissingFromCache(pages, CACHE_PAGES_EXTENSION);
    }

    @Override
    public void close() {
        super.close();
        if (this.customFileStreamFactory != null) {
            this.customFileStreamFactory.close();
        }
    }
}
