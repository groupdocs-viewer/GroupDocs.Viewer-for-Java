package com.groupdocs.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.AttachmentBase;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.image.PageImage;
import com.groupdocs.viewer.handler.ViewerImageHandler;

/**
 * Query String parameters:
 * file: string: The name of input file in storage folder.
 * width: Integer: The width of output image.
 * height: Integer: The height of output image.
 * page: Integer: The page number that needs to be viewed.
 */
@WebServlet("/attachment/image")
public class AttachmentImageServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/png");
        ViewerImageHandler handler = Utils.createViewerImageHandler();

        ImageOptions o = new ImageOptions();
        int pageNumber = Integer.valueOf(request.getParameter("page"));
        /*if (request.getParameterMap().containsKey("width"))
            o.setWidth(Integer.valueOf(request.getParameter("width")));
        if (request.getParameterMap().containsKey("height"))
            o.setHeight(Integer.valueOf(request.getParameter("height")));*/
        String watermarkText = request.getParameter("watermarkText");
        if(watermarkText!=null && watermarkText.length()>0)
        	o.setWatermark(Utils.getWatermark(watermarkText,request.getParameter("watermarkColor"),
        			request.getParameter("watermarkPosition"),request.getParameter("watermarkWidth")));
        
        String filename = request.getParameter("file");
        String attachmentName = request.getParameter("attachment");  
		try {
			DocumentInfoContainer documentInfo = handler.getDocumentInfo(filename);			
			List<AttachmentBase> attachments = documentInfo.getAttachments();
			attachments.stream().filter(attachmentBase  -> attachmentBase.getName().equalsIgnoreCase(attachmentName)
					).findAny().ifPresent(attachment ->{
		        List<PageImage> pages = Utils.loadPageImageListFromAttachment(handler,attachment, o);
		        pages.stream().filter(
		                predicate -> predicate.getPageNumber() == pageNumber
		        ).findAny().ifPresent(pageImage -> {
		        	Utils.writeToResponse(pageImage.getStream(), response);		        	
		        });
			});
			
		} catch (Exception e) {
			throw new FileNotFoundException();
		}
    }
}

