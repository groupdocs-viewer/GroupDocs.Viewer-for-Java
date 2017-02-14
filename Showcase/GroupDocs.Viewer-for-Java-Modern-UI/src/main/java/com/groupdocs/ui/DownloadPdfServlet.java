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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/download/pdf")
public class DownloadPdfServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/pdf");
        String filename = request.getParameter("file");
        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();

        InputStream pdf = null;
        try {
            pdf = handler.getPdfFile(filename).getStream();
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        Utils.writeToResponse(pdf, response);
    }
}

