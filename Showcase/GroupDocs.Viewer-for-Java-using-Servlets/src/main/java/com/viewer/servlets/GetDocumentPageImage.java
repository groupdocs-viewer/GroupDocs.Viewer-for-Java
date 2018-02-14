package com.viewer.servlets;

import com.groupdocs.viewer.converter.options.ConvertImageFileType;
import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.Transformation;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.image.PageImage;
import com.viewer.ViewerUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@WebServlet("/GetDocumentPageImage")
public class GetDocumentPageImage extends HttpServlet {
    private final int DEFAULT_IMAGE_TYPE = ConvertImageFileType.JPG;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        lock.lock();

        String path = request.getParameter("path");
//        boolean usePdf = Boolean.valueOf(request.getParameter("usePdf"));
//        boolean useHtmlBasedEngine = Boolean.valueOf(request.getParameter("useHtmlBasedEngine"));
        boolean rotate = Boolean.valueOf(request.getParameter("rotate"));
        int width = Integer.valueOf(request.getParameter("width"));
        int pageindex = Integer.valueOf(request.getParameter("pageindex"));
//        int quality = Integer.valueOf(request.getParameter("quality"));

        response.addHeader("ContentType", ViewerUtils.getContentTypeByExtenString(DEFAULT_IMAGE_TYPE));


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
        try {
            pageImages = ViewerUtils.getViewerImageHandler().getPages(path, imageOptions);
        } catch (Exception x) {
            if (lock.isLocked()) {
                lock.unlock();
            }
            throw new ServletException(x);
        }

        for (PageImage image : pageImages) {
            int myNumber = image.getPageNumber();
            if (image.getPageNumber() == pageNumber) {
                PageImage pageImage = image;

                ViewerUtils.copyStream(pageImage.getStream(), response.getOutputStream());
                break;
            }
        }

        if (lock.isLocked()) {
            lock.unlock();
        }
    }
}

