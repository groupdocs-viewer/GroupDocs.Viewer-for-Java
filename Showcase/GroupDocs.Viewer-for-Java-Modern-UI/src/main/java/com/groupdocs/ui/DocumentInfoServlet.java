package com.groupdocs.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.options.DocumentInfoOptions;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/document/info")
public class DocumentInfoServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        String filename = request.getParameter("file");
        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();

        DocumentInfoContainer info = null;
        try {
            DocumentInfoOptions options = new DocumentInfoOptions(filename);
            info = handler.getDocumentInfo(options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        new ObjectMapper().writeValue(response.getWriter(), info);
    }
}

