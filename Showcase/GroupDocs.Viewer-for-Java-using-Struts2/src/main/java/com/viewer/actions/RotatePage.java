package com.viewer.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.containers.RotatePageContainer;
import com.groupdocs.viewer.domain.options.RotatePageOptions;
import com.viewer.ViewerUtils;
import com.viewer.model.RotatePageParameters;
import com.viewer.model.RotatePageResponse;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RotatePage {

    public InputStream result;

    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        RotatePageParameters parameters = new ObjectMapper().readValue(request.getInputStream(), RotatePageParameters.class);

        String guid = parameters.getPath();
        int pageIndex = parameters.getPageNumber();

        DocumentInfoContainer documentInfoContainer = ViewerUtils.factoryDocumentInfoContainerFromImageHandler(guid);

        List<PageData> pageList = new ArrayList<PageData>();
        pageList = documentInfoContainer.getPages();
        int pageNumber = pageList.indexOf(pageIndex);

        RotatePageOptions rotatePageOptions = new RotatePageOptions(guid, 1, parameters.getRotationAmount());
        RotatePageContainer rotatePageContainer = ViewerUtils.getViewerImageHandler().rotatePage(rotatePageOptions);

        int currentPage = rotatePageContainer.getCurrentRotationAngle();

        RotatePageResponse rotatePageResponse = new RotatePageResponse();
        rotatePageResponse.setResultAngle(currentPage);

        this.result = new ByteArrayInputStream(new ObjectMapper().writeValueAsBytes(result));
        return "success";

    }

    public InputStream getResult() {
        return this.result;
    }
}
