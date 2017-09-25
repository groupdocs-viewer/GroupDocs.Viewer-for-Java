package com.viewer.actions;

import com.groupdocs.viewer.domain.html.HtmlResource;
import com.viewer.ViewerUtils;
import com.viewer.model.Utils;
import com.viewer.model.helper.DotNetToJavaStringHelper;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class GetResourceForHtml {

    private InputStream result;
    private String contentType;

    public String execute() throws Throwable {

        HttpServletRequest request = ServletActionContext.getRequest();

        String resourceName = request.getParameter("resourceName");
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        if (!DotNetToJavaStringHelper.isNullOrEmpty(resourceName) && resourceName.indexOf("/") >= 0) {
            resourceName = resourceName.replace("/", "");
        }

        HtmlResource resource = new HtmlResource();
        resource.setResourceName(resourceName);
        resource.setResourceType(Utils.GetResourceType(resourceName));
        resource.setDocumentPageNumber(pageNumber);

        this.result = ViewerUtils.getViewerHtmlHandler().getResource(request.getParameter("documentPath"), resource);
        this.contentType = Utils.GetImageMimeTypeFromFilename(resourceName);
        return "success";
    }

    public String getContentType() {
        return this.contentType;
    }

    public InputStream getResult() {
        return this.result;
    }

}
