package com.viewer.actions;

import com.groupdocs.viewer.domain.containers.FileContainer;
import com.groupdocs.viewer.domain.options.PdfFileOptions;
import com.viewer.ViewerUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

public class GetPdfWithPrintDialog {


    private InputStream result;

    public String execute() throws Throwable {

        HttpServletRequest request = ServletActionContext.getRequest();

        PdfFileOptions options = new PdfFileOptions();
        options.setGuid(request.getParameter("path"));
        options.setAddPrintAction(true);

        FileContainer pdf = ViewerUtils.getViewerHtmlHandler().getPdfFile(options);

        this.result = pdf.getStream();
        return "success";

    }

    public InputStream getResult() {
        return this.result;
    }

}
