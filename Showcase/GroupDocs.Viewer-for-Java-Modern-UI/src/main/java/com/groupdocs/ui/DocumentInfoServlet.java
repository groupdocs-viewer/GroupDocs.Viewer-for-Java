package com.groupdocs.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;

@WebServlet("/document/pages")
public class DocumentInfoServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        String filename = request.getParameter("file");
        if (Utils.isValidUrl(filename))
        	filename = Utils.downloadToStorage(filename);
        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();
        ResultModel model = new ResultModel();
        DocumentInfoContainer info = null;
        try {
            info = handler.getDocumentInfo(filename);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
        
        model.pages = info.getPages();
        info.getAttachments().forEach(attachment -> {
        	List<Integer> count = new ArrayList<>();
        	List<PageHtml> pages = new ArrayList<>();
			try {
				pages = handler.getPages(attachment);
				for (int i = 1; i <= pages.size(); i++){
	                count.add(i);
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
            model.attachments.add(new Attachment(attachment.getName(), count));
        });
       
        new ObjectMapper().writeValue(response.getWriter(), model);
    }
    public class ResultModel{
    	List<PageData> pages;
    	List<Attachment> attachments;
        public ResultModel(){
            pages = new ArrayList<>();
            attachments = new ArrayList<>();
        }
		public List<PageData> getPages() {
			return pages;
		}
		public void setPages(List<PageData> pages) {
			this.pages = pages;
		}
		public List<Attachment> getAttachments() {
			return attachments;
		}
		public void setAttachments(List<Attachment> attachments) {
			this.attachments = attachments;
		}
    }
    
    public class Attachment{
    	String Name;		
		List<Integer> Count;
        public Attachment(String name, List<Integer> count){
            Name = name;
            Count = count;
        }
        public String getName() {
			return Name;
		}
        public void setName(String name) {
			Name = name;
		}
		public List<Integer> getCount() {
			return Count;
		}
		public void setCount(List<Integer> count) {
			Count = count;
		}
    }
}

