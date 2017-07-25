package com.groupdocs.ui;

import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.AttachmentBase;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Query String parameters:
 * file: string: The name of input file in storage folder.
 * zoom: Integer: The zoom factor.
 * page: Integer: The page number that needs to be viewed.
 */
@WebServlet("/attachment/resource")
public class AttachmentResourceServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();

        HtmlOptions o = new HtmlOptions();
        int pageNumber = Integer.valueOf(request.getParameter("page"));
        o.setPageNumbersToRender(Arrays.asList(pageNumber));
        o.setPageNumber(pageNumber);
        o.setCountPagesToRender(1);
        String filename = request.getParameter("file");
        String attachmentName = request.getParameter("attachment");
        
        String attachmentPath = Utils.getProjectProperty("cache.path")+"\\sample_msg\\attachments";
        String attachmentFile = attachmentPath+File.separator+attachmentName;
        
        String resourceName = request.getParameter("resource");  
        System.out.println("resourceName:"+resourceName);
        try {
			DocumentInfoContainer documentInfo = handler.getDocumentInfo(filename);
			List<AttachmentBase> attachments = documentInfo.getAttachments();
			attachments.stream().filter(attachmentBase  -> attachmentBase.getName().equalsIgnoreCase(attachmentName)
			).findAny().ifPresent(attachment ->{
				List<PageHtml> list = Utils.loadPageHtmlListFromAttachment(handler, attachment, o); 
        	//List<PageHtml> list = Utils.loadPageHtmlList(handler, attachmentFile, o);  	
        	list.stream().filter(
				pageHtml -> pageHtml.getPageNumber() == pageNumber
				).findAny().ifPresent(
						pageHtml -> pageHtml.getHtmlResources().stream().filter(
								htmlResource -> htmlResource.getResourceName().toLowerCase().endsWith(resourceName.toLowerCase())
								).findAny().ifPresent(htmlResource -> {
									switch (htmlResource.getResourceType()) {
									case Font:
			                            response.setContentType("application/font-woff");
			                            break;
			                        case Style:
			                            response.setContentType("text/css");
			                            break;
			                        case Image:
			                            response.setContentType("image/jpeg");
			                            break;
			                        default:
			                            response.setContentType("application/octet-stream");
									}
				                    try (InputStream is = handler.getResource(filename, htmlResource)) {
				                        Utils.writeToResponse(is, response);
				                    } catch (Exception x) {
				                        throw new RuntimeException(x);
				                    }
			                  
								})
						
			        );
			});
		} catch (Exception e) {
			
		}
    }
}
