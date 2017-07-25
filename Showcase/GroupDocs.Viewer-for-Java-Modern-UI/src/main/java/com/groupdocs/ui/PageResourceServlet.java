package com.groupdocs.ui;

import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Query String parameters:
 * file: string: The name of input file in storage folder.
 * zoom: Integer: The zoom factor.
 * page: Integer: The page number that needs to be viewed.
 */
@WebServlet("/page/resource")
public class PageResourceServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();

        HtmlOptions o = new HtmlOptions();
        int pageNumber = Integer.valueOf(request.getParameter("page"));
        o.setPageNumbersToRender(Arrays.asList(pageNumber));
        o.setPageNumber(pageNumber);
        o.setCountPagesToRender(1);

        String filename = request.getParameter("file");
        String resourceName = request.getParameter("resource");
        System.out.println("resourceName:"+resourceName);
        List<PageHtml> list = Utils.loadPageHtmlList(handler, filename, o);
        list.stream().filter(
                pageHtml -> pageHtml.getPageNumber() == pageNumber
        ).findAny().ifPresent(
                pageHtml -> pageHtml.getHtmlResources().stream().filter(
                        htmlResource -> htmlResource.getResourceName().toLowerCase().endsWith(resourceName.toLowerCase())
                ).findAny().ifPresent(htmlResource -> {
                    switch (htmlResource.getResourceType()) {
                        case Font:
                            response.setContentType("application/font-woff");
                            break;
                        case Style:
                            response.setContentType("text/css");
                            break;
                        case Image:
                            response.setContentType("image/jpeg");
                            break;
                        default:
                            response.setContentType("application/octet-stream");
                    }
                    try (InputStream is = handler.getResource(filename, htmlResource)) {
                        Utils.writeToResponse(is, response);
                    } catch (Exception x) {
                        throw new RuntimeException(x);
                    }
                })
        );
    }
}
