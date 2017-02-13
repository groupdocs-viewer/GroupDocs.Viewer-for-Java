package com.groupdocs.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.options.DocumentInfoOptions;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/document/pages")
public class DocumentPagesServlet
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

        List<PageData> result = new ArrayList<>();
        info.getPages().forEach(pageData -> {
            result.add(pageData);
        });

        new ObjectMapper().writeValue(response.getWriter(), result);
    }
}

