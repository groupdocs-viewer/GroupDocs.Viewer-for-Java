package com.groupdocs.ui.viewer.viewer;

import com.groupdocs.ui.viewer.cache.ViewerCache;
import com.groupdocs.viewer.options.LoadOptions;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.options.Rotation;
import com.groupdocs.viewer.options.ViewInfoOptions;

public class PngViewer extends CustomViewer<PngViewOptions> {

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
        PngViewOptions createdPngViewOptions = new PngViewOptions(new CustomPageStreamFactory(".png"));

        if (passedPageNumber >= 0 && newAngle != 0) {
            Rotation rotationAngle = getRotationByAngle(newAngle);
            createdPngViewOptions.rotatePage(passedPageNumber, rotationAngle);
        }

        setWatermarkOptions(createdPngViewOptions);

        return createdPngViewOptions;
    }

    private com.groupdocs.viewer.options.PdfViewOptions createPdfViewOptions() {
        PdfViewOptions pdfViewOptions = new PdfViewOptions(
            new CustomFileStreamFactory(getCachePdfFileExtension()));
        setWatermarkOptions(pdfViewOptions);
        return pdfViewOptions;
    }

    @Override
    protected String getCachePagesExtension() {
        return ".png";
    }
}
