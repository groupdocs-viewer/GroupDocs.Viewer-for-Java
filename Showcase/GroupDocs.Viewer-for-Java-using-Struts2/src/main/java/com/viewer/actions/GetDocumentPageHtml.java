package com.viewer.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.html.HtmlResource;
import com.groupdocs.viewer.domain.html.HtmlResourceType;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.viewer.ViewerUtils;
import com.viewer.model.GetDocumentPageHtmlParameters;
import com.viewer.model.Utils;
import com.viewer.model.helper.DotNetToJavaStringHelper;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class GetDocumentPageHtml {

    List<String> temp_cssList;
    private InputStream result;

    public String execute() {

        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();

        response.addHeader("Content-Type", "application/json");
        GetDocumentPageHtmlParameters parameters = null;
        try {
            parameters = new ObjectMapper().readValue(request.getInputStream(), GetDocumentPageHtmlParameters.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (DotNetToJavaStringHelper.isNullOrWhiteSpace(parameters.getPath())) {
            out.println("A document path must be specified path");
        }

        String[] cssList = null;
        int pageNumber = parameters.getPageIndex() + 1;

        HtmlOptions htmlOptions = new HtmlOptions();
        htmlOptions.setPageNumber(parameters.getPageIndex() + 1);
        htmlOptions.setCountPagesToRender(1);
        htmlOptions.setResourcesEmbedded(false);
        htmlOptions.setHtmlResourcePrefix(
                "/GetResourceForHtml?documentPath=" + parameters.getPath() + "&pageNumber={page-number}&resourceName=");

        List<PageHtml> htmlPages = null;
        try {
            htmlPages = GetHtmlPages(parameters.getPath(), htmlOptions);
        } catch (Exception ex) {
            try {
                throw new ServletException(ex);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }


        String pageHtml = htmlPages.size() > 0 ? htmlPages.get(0).getHtmlContent() : null;
        String[] pageCss = temp_cssList.size() > 0 ? new String[]{String.join(" ", temp_cssList)} : null;

        this.result = new ByteArrayInputStream(String.join(pageHtml, pageCss).getBytes());
        return "success";
    }

    public InputStream getResult() {
        return this.result;
    }

///////////////////////

    private List<PageHtml> GetHtmlPages(String filePath, HtmlOptions htmlOptions) throws Exception {

        List<PageHtml> htmlPages = ViewerUtils.getViewerHtmlHandler().getPages(filePath, htmlOptions);
        temp_cssList = new ArrayList<String>();

        for (PageHtml page : htmlPages) {

            int indexOfBodyOpenTag = page.getHtmlContent().indexOf("<body>");

            if (indexOfBodyOpenTag > 0) {
                page.setHtmlContent(page.getHtmlContent().substring(indexOfBodyOpenTag + "<body>".length()));
            }

            int indexOfBodyCloseTag = page.getHtmlContent().indexOf("</body>");

            if (indexOfBodyCloseTag > 0) {
                page.setHtmlContent(page.getHtmlContent().substring(0, indexOfBodyCloseTag));
            }

            /////////////////////////

            List<HtmlResource> test = page.getHtmlResources();

            for (HtmlResource resource : page.getHtmlResources()) {

                if (resource.getResourceType() == HtmlResourceType.Style) {
                    InputStream cssStream = ViewerUtils.getViewerHtmlHandler().getResource(filePath, resource);
                    String text = IOUtils.toString(cssStream, "UTF-8");

                    boolean needResave = false;
                    if (text.indexOf("url(\"") >= 0 && text.indexOf("url(\"/GetResourceForHtml?documentPath=") < 0) {
                        needResave = true;
                        text = text.replace("url(\"", "url(\"/GetResourceForHtml?documentPath=" + filePath
                                + "&pageNumber=" + resource.getDocumentPageNumber() + "&resourceName=");
                    }

                    if (text.indexOf("url('") >= 0 && text.indexOf("url('/GetResourceForHtml?documentPath=") < 0) {
                        needResave = true;
                        text = text.replace("url('", String.format("url(\'/GetResourceForHtml?documentPath=" + filePath
                                + "&pageNumber=" + resource.getDocumentPageNumber() + "&resourceName="));
                    }

                    temp_cssList.add(text);

                    if (needResave) {

                        String fullPath = ViewerUtils.TEMP_PATH.toString() + filePath + "/" + "html" + "/" + "resources" + "/" + "page"
                                + page.getPageNumber() + "/" + resource.getResourceName();
                        File file = new File(fullPath);

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(text);
                        bw.close();

                    }
                }
                /////////////////////////
            }
            ArrayList<String> cssClasses = Utils.GetCssClasses(page.getHtmlContent());
            for (String cssClass : cssClasses) {
                String newCssClass = "page-" + page.getPageNumber() + "-" + cssClass;

                page.setHtmlContent(page.getHtmlContent().replace(cssClass, newCssClass));
                for (int i = 0; i < temp_cssList.size(); i++) {
                    temp_cssList.set(i, temp_cssList.get(i).replace(cssClass, newCssClass));
                }
            }
        }
        return htmlPages;

    }
}
