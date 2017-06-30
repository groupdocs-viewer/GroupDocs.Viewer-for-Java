package com.groupdocs.ui;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Utilities;

import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.image.PageImage;
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
        if (request.getParameterMap().containsKey("width")) {
            o.setWidth(Integer.valueOf(request.getParameter("width")));
        }
        if (request.getParameterMap().containsKey("height")) {
            o.setHeight(Integer.valueOf(request.getParameter("height")));
        }

        String filename = request.getParameter("file");

        List<PageImage> list = Utils.loadPageImageList(handler, filename, o);
        list.stream().filter(
                predicate -> predicate.getPageNumber() == pageNumber
        ).findAny().ifPresent(pageImage -> {
        	Utils.writeToResponse(pageImage.getStream(), response);
        	
        });
    }
}

