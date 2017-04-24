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
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;

/**
 * Query String parameters:
 * file: string: The name of input file in storage folder.
 * page: Integer: The page number that needs to be viewed.
 */
@WebServlet("/page/style")
public class PageStyleServlet
        extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filename = request.getParameter("file");
        response.setContentType("text/css");
        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();

        HtmlOptions o = new HtmlOptions();
        int pageNumber = Integer.valueOf(request.getParameter("page"));
        o.setPageNumbersToRender(Arrays.asList(pageNumber));
        o.setPageNumber(pageNumber);
        o.setCountPagesToRender(1);

        List<PageHtml> list = Utils.loadPageHtmlList(handler, filename, o);
        list.stream().filter(pageHtml -> pageHtml.getPageNumber() == pageNumber).findAny().ifPresent(pageHtml -> {

            String fullHtml = pageHtml.getHtmlContent();
            StringBuilder strippedHtml = new StringBuilder();

            fullHtml = fullHtml.replace("<STYLE>", "<style>");
            fullHtml = fullHtml.replace("</STYLE>", "</style>");

            int cursor = 0;
            while (true) {
                int indexStyleStart = fullHtml.indexOf("<style>", cursor);
                int indexStyleEnd = fullHtml.indexOf("</style>", cursor);

                if (0 < indexStyleStart && indexStyleStart < indexStyleEnd) {
                    strippedHtml.append(fullHtml.substring(indexStyleStart + "<style>".length(), indexStyleEnd));
                } else {
                    break;
                }

                cursor = indexStyleEnd;
            }

            try {
                response.getWriter().write(strippedHtml.toString());
            } catch (IOException x) {
                throw new UncheckedIOException(x);
            }

        });
    }
}
