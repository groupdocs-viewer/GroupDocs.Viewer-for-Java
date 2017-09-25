package com.viewer.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.viewer.ViewerUtils;
import com.viewer.model.GetImageUrlsParameters;
import com.viewer.model.GetImageUrlsResponse;
import com.viewer.model.helper.ImageUrlHelper;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GetImageUrls {

    private InputStream result;

    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();

        GetImageUrlsParameters params = new ObjectMapper().readValue(request.getInputStream(), GetImageUrlsParameters.class);
        GetImageUrlsResponse urls = new GetImageUrlsResponse();
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

        urls.imageUrls = imageUrls;
        this.result = new ByteArrayInputStream(new ObjectMapper().writeValueAsBytes(urls));
        return "success";

    }

    public InputStream getResult() {
        return this.result;
    }
}
