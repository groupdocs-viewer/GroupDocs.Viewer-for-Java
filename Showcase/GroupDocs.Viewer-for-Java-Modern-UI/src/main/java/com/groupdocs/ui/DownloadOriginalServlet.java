package com.groupdocs.ui;

import com.groupdocs.viewer.handler.ViewerHtmlHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download/original")
public class DownloadOriginalServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filename = request.getParameter("file");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);

        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();
        InputStream original = null;
        try {
            original = handler.getFile(filename).getStream();
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        Utils.writeToResponse(original, response);
    }
}

