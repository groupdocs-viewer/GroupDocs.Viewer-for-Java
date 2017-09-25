package com.viewer.servlets;

import com.groupdocs.viewer.domain.containers.FileContainer;
import com.groupdocs.viewer.domain.options.PdfFileOptions;
import com.viewer.ViewerUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetPdfWithPrintDialog")
public class GetPdfWithPrintDialog extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.addHeader("Content-Type", "application/pdf");

        PdfFileOptions options = new PdfFileOptions();
        options.setGuid(request.getParameter("path"));
        options.setAddPrintAction(true);

        FileContainer result;
		try {
			result = ViewerUtils.getViewerHtmlHandler().getPdfFile(options);
			ViewerUtils.copyStream(result.getStream(), response.getOutputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
