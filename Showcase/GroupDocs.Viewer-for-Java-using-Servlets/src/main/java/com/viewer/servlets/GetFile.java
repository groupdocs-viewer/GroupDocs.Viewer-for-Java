package com.viewer.servlets;

import com.groupdocs.viewer.domain.containers.FileContainer;
import com.groupdocs.viewer.domain.options.PdfFileOptions;
import com.viewer.ViewerUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

@WebServlet("/GetFile")
public class GetFile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        File file = new File(request.getParameter("path"));

        String displayName = request.getParameter("path");

        String nameWithoutExtension = removeExtention(request.getParameter("path"));
        Stream fileStream;
        File newFile = new File(nameWithoutExtension + ".pdf");

        displayName = newFile.getPath();

        PdfFileOptions options = new PdfFileOptions();
        //options.set.setGuid(request.getParameter("path"));


        FileContainer pdfFileResponse = null;
        try {
			pdfFileResponse = ViewerUtils.getViewerHtmlHandler().getPdfFile(request.getParameter("path"),options);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + displayName + "\"");
        InputStream fileIn = pdfFileResponse.getStream();
        ServletOutputStream out = response.getOutputStream();

        byte[] outputByte = new byte[4096];
        while (fileIn.read(outputByte, 0, 4096) != -1) {
            out.write(outputByte, 0, 4096);
        }
        fileIn.close();
        out.flush();
        out.close();
    }


    // copy pasted a funtion outside of do and get from ViewController.Java
    public String removeExtention(String filePath) {
        // These first few lines the same as Justin's
        File f = new File(filePath);

        // if it's a directory, don't remove the extention
        if (f.isDirectory())
            return filePath;

        String name = f.getName();

        // Now we know it's a file - don't need to do any special hidden
        // checking or contains() checking because of:
        final int lastPeriodPos = name.lastIndexOf('.');
        if (lastPeriodPos <= 0) {
            // No period after first character - return name as it was passed in
            return filePath;
        } else {
            // Remove the last period and everything after it
            File renamed = new File(f.getParent(), name.substring(0, lastPeriodPos));
            return renamed.getPath();
        }
    }
}
