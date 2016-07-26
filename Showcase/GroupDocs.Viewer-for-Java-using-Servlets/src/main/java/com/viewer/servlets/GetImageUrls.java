package com.viewer.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.viewer.ViewerUtils;
import com.viewer.model.GetImageUrlsParameters;
import com.viewer.model.GetImageUrlsResponse;
import com.viewer.model.helper.ImageUrlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetImageUrls")
public class GetImageUrls extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.addHeader("Content-Type", "application/json");
        GetImageUrlsParameters params = new ObjectMapper().readValue(request.getInputStream(), GetImageUrlsParameters.class);
        GetImageUrlsResponse result = new GetImageUrlsResponse();
        DocumentInfoContainer documentInfoContainer = ViewerUtils.factoryDocumentInfoContainerFromImageHandler(params.getPath());

        int[] pageNumbers = new int[documentInfoContainer.getPages().size()];
        int count = 0;
        for (PageData page : documentInfoContainer.getPages()) {

            pageNumbers[count] = page.getNumber();
            count++;
        }

        String applicationHost = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort();
        String[] imageUrls = ImageUrlHelper.GetImageUrls(applicationHost, pageNumbers, params);

        result.imageUrls = imageUrls;

        new ObjectMapper().writeValue(response.getOutputStream(), result);

    }
}
