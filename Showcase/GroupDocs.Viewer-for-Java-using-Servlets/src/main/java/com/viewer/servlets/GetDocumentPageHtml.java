package com.viewer.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.html.HtmlResource;
import com.groupdocs.viewer.domain.html.HtmlResourceType;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.viewer.ViewerUtils;
import com.viewer.model.GetDocumentPageHtmlParameters;
import com.viewer.model.Utils;
import com.viewer.model.helper.DotNetToJavaStringHelper;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/GetDocumentPageHtml")
public class GetDocumentPageHtml extends HttpServlet {
    List<String> temp_cssList;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.addHeader("Content-Type", "application/json");
        GetDocumentPageHtmlParameters parameters = new ObjectMapper().readValue(request.getInputStream(), GetDocumentPageHtmlParameters.class);

        if (DotNetToJavaStringHelper.isNullOrWhiteSpace(parameters.getPath())) {
            System.out.println("A document path must be specified path");
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
            throw new ServletException(ex);
        }


        String pageHtml = htmlPages.size() > 0 ? htmlPages.get(0).getHtmlContent() : "";
        String[] pageCss = temp_cssList.size() > 0 ? new String[]{String.join(" ", temp_cssList)} : new String[]{};

        Map<String, Object> a = new HashMap<String, Object>();
        a.put("pageHtml", pageHtml);
        a.put("pageCss", pageCss);

        new ObjectMapper().writeValue(response.getOutputStream(), a);
    }
///////////////////////

    private List<PageHtml> GetHtmlPages(String filePath, HtmlOptions htmlOptions) throws Exception {

        List<PageHtml> htmlPages = ViewerUtils.getViewerHtmlHandler().getPages(filePath, htmlOptions);
        temp_cssList = new ArrayList<String>();

        for (PageHtml page : htmlPages) {

            String fullHtml = page.getHtmlContent();
            String strippedHtml = "";
            if (fullHtml.indexOf("</title>") > 0 && fullHtml.indexOf("</head>") > 0) {
                strippedHtml += fullHtml.substring(fullHtml.indexOf("</title>") + "</title>".length(), fullHtml.indexOf("</head>"));
            }
            if (fullHtml.indexOf("<body>") > 0 && fullHtml.indexOf("</body>") > 0) {
                strippedHtml += fullHtml.substring(fullHtml.indexOf("<body>") + "<body>".length(), fullHtml.indexOf("</body>"));
            }
            page.setHtmlContent(strippedHtml);

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

                        String fullPath = ViewerUtils.TEMP_PATH + filePath + "/" + "html" + "/" + "resources" + "/" + "page"
                                + page.getPageNumber() + "/" + resource.getResourceName();
                        File file = new File(fullPath);

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
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
