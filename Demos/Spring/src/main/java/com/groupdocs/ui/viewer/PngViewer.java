package com.groupdocs.ui.viewer;

import com.groupdocs.ui.cache.ViewerCache;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ViewInfo;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class PngViewer extends CustomViewer {

    private final PngViewOptions pngViewOptions;

    public PngViewer(String filePath, ViewerCache cache, LoadOptions loadOptions) {
        this(filePath, cache, loadOptions, -1, 0);
    }

    public PngViewer(String filePath, ViewerCache cache, LoadOptions loadOptions, int pageNumber/* = -1*/, int newAngle/* = 0*/) {
        super(filePath, cache, loadOptions);
        this.pngViewOptions = this.createPngViewOptions(pageNumber, newAngle);
        this.pdfViewOptions = this.createPdfViewOptions();
        this.viewInfoOptions = ViewInfoOptions.fromPngViewOptions(this.pngViewOptions);
    }

    private PngViewOptions createPngViewOptions(int passedPageNumber/* = -1*/, int newAngle/* = 0*/) {
        PngViewOptions createdPngViewOptions = new PngViewOptions(new CustomPageStreamFactory(".png"));

        if (passedPageNumber >= 0 && newAngle != 0) {
            Rotation rotationAngle = getRotationByAngle(newAngle);
            createdPngViewOptions.rotatePage(passedPageNumber, rotationAngle);
        }

        setWatermarkOptions(createdPngViewOptions);

        return createdPngViewOptions;
    }

    private com.groupdocs.viewer.options.PdfViewOptions createPdfViewOptions() {
        PdfViewOptions pdfViewOptions = new PdfViewOptions(new CustomFileStreamFactory(".pdf"));
        setWatermarkOptions(pdfViewOptions);
        return pdfViewOptions;
    }

    public void createCache() {
        ViewInfo viewInfo = this.getViewInfo();
        if (viewInfo == null) {
            throw new IllegalStateException("Can't get ViewInfo. The problem can be with deserealization (DESERIALIZATION_CLASSES)");
        }

        synchronized (this.filePath) {
            int[] missingPages = this.getPagesMissingFromCache(viewInfo.getPages());

            if (missingPages.length > 0) {
                this.viewer.view(this.pngViewOptions, missingPages);
            }
        }
    }

    private int[] getPagesMissingFromCache(List<Page> pages) {
        List<Integer> missingPages = new ArrayList<>();
        for (Page page : pages) {
            String pageKey = "p" + page.getNumber() + ".png";
            if (this.cache.doesNotContains(pageKey)) {
                missingPages.add(page.getNumber());
            }
        }

        return ArrayUtils.toPrimitive(missingPages.toArray(new Integer[0]));
    }
}
