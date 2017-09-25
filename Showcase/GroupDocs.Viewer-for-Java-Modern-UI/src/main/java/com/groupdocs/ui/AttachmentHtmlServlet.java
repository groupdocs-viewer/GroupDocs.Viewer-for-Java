package com.groupdocs.ui;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.AttachmentBase;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;

/**
 * Query String parameters:
 * file: string: The name of input file in storage folder.
 * zoom: Integer: The zoom factor.
 * page: Integer: The page number that needs to be viewed.
 */
@WebServlet("/attachment/html")
public class AttachmentHtmlServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filename = request.getParameter("file");
        String attachmentName = request.getParameter("attachment");
        response.setContentType("text/html");
        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();
        int pageNumber = Integer.valueOf(request.getParameter("page"));
        
        HtmlOptions o = new HtmlOptions();
        /*o.setPageNumbersToRender(Arrays.asList(pageNumber));
        o.setPageNumber(pageNumber);
        o.setCountPagesToRender(1);
        o.setHtmlResourcePrefix("/attachment/resource?file="+filename+"&attachment="+attachmentName+"&page="+pageNumber+"&resource=");
        */String watermarkText = request.getParameter("watermarkText");
        if(watermarkText!=null && watermarkText.length()>0)
        	o.setWatermark(Utils.getWatermark(watermarkText,request.getParameter("watermarkColor"),
        			request.getParameter("watermarkPosition"),request.getParameter("watermarkWidth")));
        /*(String.format(
                "/attachment/resource?file=%s&attachment=%s&page=%d&resource=",
                filename,
                attachmentName,
                pageNumber
        ));*/
        
        /* 
        String attachmentPath = Utils.getProjectProperty("cache.path")+"\\sample_msg\\attachments";
        String attachmentFile = attachmentPath+File.separator+attachmentName;
        
        File theDir = new File(attachmentPath);
        if (theDir.exists()){
			List<PageHtml> pages = Utils.loadPageHtmlList(handler,attachmentFile, o);
			pages.stream().filter(pageHtml -> pageHtml.getPageNumber() == pageNumber).findAny().ifPresent(pageHtml -> {
	            String fullHtml = pageHtml.getHtmlContent();
	            try {
	                response.getWriter().write(fullHtml);
	            } catch (IOException x) {
	                throw new UncheckedIOException(x);
	            }
	        });
        }else{*/
			try {
				DocumentInfoContainer documentInfo = handler.getDocumentInfo(filename);
				List<AttachmentBase> attachments = documentInfo.getAttachments();
				attachments.stream().filter(attachmentBase  -> attachmentBase.getName().equalsIgnoreCase(attachmentName)
						).findAny().ifPresent(attachment ->{
					List<PageHtml> list = Utils.loadPageHtmlListFromAttachment(handler,attachment,o);
				    	list.stream().filter(page -> page.getPageNumber() == pageNumber).findAny().ifPresent(pageHtml -> {
				    		String fullHtml = pageHtml.getHtmlContent();
					        try {
					            response.getWriter().write(fullHtml);
					        } catch (IOException x) {
					            throw new UncheckedIOException(x);
					        }
			        });
				});
			} catch (Exception e) {
				//throw new FileNotFoundException();
				System.out.println("Exception in attach html:"+e.getMessage());
			}
       /* }*/
    }
}
