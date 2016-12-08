package com.viewer.servlets;

import com.groupdocs.viewer.domain.html.HtmlResource;
import com.viewer.ViewerUtils;
import com.viewer.model.Utils;
import com.viewer.model.helper.DotNetToJavaStringHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/GetResourceForHtml")
public class GetResourceForHtml extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String resourceName = request.getParameter("resourceName");
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        if (!DotNetToJavaStringHelper.isNullOrEmpty(resourceName) && resourceName.indexOf("/") >= 0) {
            resourceName = resourceName.replace("/", "");
        }

        HtmlResource resource = new HtmlResource();
        resource.setResourceName(resourceName);
        resource.setResourceType(Utils.GetResourceType(resourceName));
        resource.setDocumentPageNumber(pageNumber);

        InputStream stream;
		try {
			stream = ViewerUtils.getViewerHtmlHandler().getResource(request.getParameter("documentPath"), resource);

	        response.addHeader("Content-Type", Utils.GetImageMimeTypeFromFilename(resourceName));


	        ViewerUtils.copyStream(stream, response.getOutputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
