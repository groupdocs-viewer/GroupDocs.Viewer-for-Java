package com.viewer.actions;

import com.groupdocs.viewer.domain.containers.FileContainer;
import com.groupdocs.viewer.domain.options.PdfFileOptions;
import com.viewer.ViewerUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class GetFile {

    private InputStream result;
    private String attachmentName;

    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();

        this.result = Files.newInputStream(ViewerUtils.STORAGE_PATH.resolve(request.getParameter("path")));
        this.attachmentName = request.getParameter("path");
        return "success";
    }

    public InputStream getResult() {
        return this.result;
    }

    public String getAttachmentName() {
        return this.attachmentName;
    }
}

