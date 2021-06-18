package com.groupdocs.ui.viewer.viewer;

import com.groupdocs.ui.viewer.cache.ViewerCache;
import com.groupdocs.viewer.interfaces.ResourceStreamFactory;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.Resource;

import java.io.*;

public class HtmlViewer extends CustomViewer<HtmlViewOptions> {

    public HtmlViewer(String filePath, ViewerCache cache, LoadOptions loadOptions) {
        this(filePath, cache, loadOptions, -1, 0);
    }

    public HtmlViewer(String filePath, ViewerCache cache, LoadOptions loadOptions, int pageNumber/* = -1*/, int newAngle/* = 0*/) {
        super(filePath, cache, loadOptions);
        this.viewOptions = this.createHtmlViewOptions(pageNumber, newAngle);
        this.viewInfoOptions = ViewInfoOptions.fromHtmlViewOptions(this.viewOptions);
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

        if (passedPageNumber >= 0 && newAngle != 0) {
            Rotation rotationAngle = getRotationByAngle(newAngle);
            htmlViewOptions.rotatePage(passedPageNumber, rotationAngle);
        }

        return htmlViewOptions;
    }

    @Override
    protected String getCachePagesExtension() {
        return ".html";
    }
}
