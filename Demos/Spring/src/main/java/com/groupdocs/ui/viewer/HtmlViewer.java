package com.groupdocs.ui.viewer;

import com.groupdocs.ui.cache.ViewerCache;
import com.groupdocs.viewer.interfaces.ResourceStreamFactory;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.Resource;
import com.groupdocs.viewer.results.ViewInfo;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HtmlViewer extends CustomViewer {

    private final HtmlViewOptions htmlViewOptions;

    public HtmlViewer(String filePath, ViewerCache cache, LoadOptions loadOptions) {
        this(filePath, cache, loadOptions, -1, 0);
    }

    public HtmlViewer(String filePath, ViewerCache cache, LoadOptions loadOptions, int pageNumber/* = -1*/, int newAngle/* = 0*/) {
        super(filePath, cache, loadOptions);
        this.htmlViewOptions = this.createHtmlViewOptions(pageNumber, newAngle);
        this.pdfViewOptions = this.createPdfViewOptions();
        this.viewInfoOptions = ViewInfoOptions.fromHtmlViewOptions(this.htmlViewOptions);
    }

    private com.groupdocs.viewer.options.HtmlViewOptions createHtmlViewOptions(int passedPageNumber/* = -1*/, int newAngle/* = 0*/) {
        HtmlViewOptions htmlViewOptions = HtmlViewOptions.forExternalResources(new CustomPageStreamFactory(".html"), new ResourceStreamFactory() {
            @Override
            public OutputStream createResourceStream(int pageNumber, Resource resource) {
                String fileName = "p" + pageNumber + "_" + resource.getFileName();
                String cacheFilePath = cache.getCacheFilePath(fileName);

                try {
                    return new FileOutputStream(cacheFilePath);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String createResourceUrl(int pageNumber, Resource resource) {
                String urlPrefix = "/viewer/resources/" + new File(filePath).getName().replace(".", "_");
                return urlPrefix + "/p" + pageNumber + "_" + resource.getFileName();
            }

            @Override
            public void closeResourceStream(int pageNumber, Resource resource, OutputStream outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        });

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
        PdfViewOptions pdfViewOptions = new PdfViewOptions(new CustomFileStreamFactory(".pdf"));
        setCommonViewOptions(pdfViewOptions);
        return pdfViewOptions;
    }

    private void setCommonViewOptions(com.groupdocs.viewer.options.ViewOptions viewOptions){
        viewOptions.getSpreadsheetOptions().setTextOverflowMode(TextOverflowMode.HIDE_TEXT);
        viewOptions.getSpreadsheetOptions().setSkipEmptyColumns(true);
        viewOptions.getSpreadsheetOptions().setSkipEmptyRows(true);
        setWatermarkOptions(viewOptions);
    }

    public void createCache() {
        ViewInfo viewInfo = this.getViewInfo();

        synchronized (this.filePath) {
            int[] missingPages = this.getPagesMissingFromCache(viewInfo.getPages());

            if (missingPages.length > 0) {
                this.viewer.view(this.htmlViewOptions, missingPages);
            }
        }
    }

    private int[] getPagesMissingFromCache(List<Page> pages) {
        List<Integer> missingPages = new ArrayList<Integer>();
        for (Page page : pages) {
            String pageKey = "p" + page.getNumber() + ".html";
            if (this.cache.doesNotContains(pageKey)) {
                missingPages.add(page.getNumber());
            }
        }

        return ArrayUtils.toPrimitive(missingPages.toArray(new Integer[0]));
    }
}
