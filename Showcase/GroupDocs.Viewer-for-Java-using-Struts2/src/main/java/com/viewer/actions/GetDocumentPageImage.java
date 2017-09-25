package com.viewer.actions;

import com.groupdocs.viewer.converter.options.ConvertImageFileType;
import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.Transformation;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.image.PageImage;
import com.viewer.ViewerUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class GetDocumentPageImage {
    private final ConvertImageFileType DEFAULT_IMAGE_TYPE = ConvertImageFileType.JPG;
    private final ReentrantLock lock = new ReentrantLock();
    private InputStream result;

    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

//        lock.lock();

        String path = request.getParameter("path");
//        boolean usePdf = Boolean.valueOf(request.getParameter("usePdf"));
//        boolean useHtmlBasedEngine = Boolean.valueOf(request.getParameter("useHtmlBasedEngine"));
        boolean rotate = Boolean.valueOf(request.getParameter("rotate"));
        int width = Integer.valueOf(request.getParameter("width"));
        int pageindex = Integer.valueOf(request.getParameter("pageindex"));
//        int quality = Integer.valueOf(request.getParameter("quality"));


        int pageIndex = pageindex;
        int pageNumber = pageIndex + 1;

        ImageOptions imageOptions = new ImageOptions();
        imageOptions.setConvertImageFileType(DEFAULT_IMAGE_TYPE);
        imageOptions.setTransformations(rotate ? Transformation.Rotate : Transformation.None);

        if (rotate && width != 0) {
            DocumentInfoContainer documentInfoContainer = ViewerUtils.factoryDocumentInfoContainerFromImageHandler(path);

            int side = width;
            int pageAngle = 0;
            int count = 0;
            for (PageData page : documentInfoContainer.getPages()) {
                if (count == pageIndex) {
                    pageAngle = page.getAngle();
                }
                count++;

            }
            if (pageAngle == 90 || pageAngle == 270) {
                imageOptions.setHeight(side);
            } else {
                imageOptions.setWidth(side);
            }
        }


        List<PageImage> pageImages = null;
        pageImages = ViewerUtils.getViewerImageHandler().getPages(path, imageOptions);


        for (PageImage image : pageImages) {
            if (image.getPageNumber() == pageNumber) {
                this.result = image.getStream();
                break;
            }
        }

        if (lock.isLocked()) {
            lock.unlock();
        }

        return "success";
    }

    public InputStream getResult() {
        return this.result;
    }
}

