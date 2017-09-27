package com.groupdocs.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.Transformation;
import com.groupdocs.viewer.domain.image.PageImage;
import com.groupdocs.viewer.domain.options.RotatePageOptions;
import com.groupdocs.viewer.handler.ViewerImageHandler;

/**
 * Query String parameters:
 * file: string: The name of input file in storage folder.
 * width: Integer: The width of output image.
 * height: Integer: The height of output image.
 * page: Integer: The page number that needs to be viewed.
 */
@WebServlet("/page/image")
public class PageImageServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/png");
        ViewerImageHandler handler = Utils.createViewerImageHandler();
        
        ImageOptions o = new ImageOptions();
        int pageNumber = Integer.valueOf(request.getParameter("page"));
        o.setPageNumbersToRender(Arrays.asList(pageNumber));
        o.setPageNumber(pageNumber);
        o.setCountPagesToRender(1);

        String watermarkText = request.getParameter("watermarkText");
        if(watermarkText!=null && watermarkText.length()>0)
        	o.setWatermark(Utils.getWatermark(watermarkText,request.getParameter("watermarkColor"),
        			request.getParameter("watermarkPosition"),request.getParameter("watermarkWidth")));

        String filename = request.getParameter("file");
        if (Utils.isValidUrl(filename))
        	filename = Utils.downloadToStorage(filename);


              List<PageImage> list = Utils.loadPageImageList(handler, filename, o);
        list.stream().filter(
                predicate -> predicate.getPageNumber() == pageNumber
        ).findAny().ifPresent(pageImage -> {
        	Utils.writeToResponse(pageImage.getStream(), response);
        	
        });
    }
}

