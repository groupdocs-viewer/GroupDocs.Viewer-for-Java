package com.viewer.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.options.RotatePageOptions;
import com.viewer.ViewerUtils;
import com.viewer.model.RotatePageParameters;
import com.viewer.model.RotatePageResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RotatePage")
public class RotatePage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.addHeader("Content-Type", "application/json");
        RotatePageParameters parameters = new ObjectMapper().readValue(request.getInputStream(), RotatePageParameters.class);

        String guid = parameters.getPath();
        int pageIndex = parameters.getPageNumber();

        DocumentInfoContainer documentInfoContainer = ViewerUtils.factoryDocumentInfoContainerFromImageHandler(guid);

        List<PageData> pageList = new ArrayList<PageData>();
        pageList = documentInfoContainer.getPages();
        int pageNumber = pageList.indexOf(pageIndex);

        RotatePageOptions rotatePageOptions = new RotatePageOptions(1, parameters.getRotationAmount(),guid);

        try {
            ViewerUtils.getViewerImageHandler().rotatePage(guid,rotatePageOptions);
        } catch (Exception x) {
            throw new ServletException(x);
        }


        int currentPage = pageList.get(pageNumber).getAngle();

        RotatePageResponse result = new RotatePageResponse();
        result.setResultAngle(currentPage);

        new ObjectMapper().writeValue(response.getOutputStream(), result);

    }
}