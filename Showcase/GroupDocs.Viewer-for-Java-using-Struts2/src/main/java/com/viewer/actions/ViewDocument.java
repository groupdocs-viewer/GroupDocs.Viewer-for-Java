package com.viewer.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.converter.options.FileDataOptions;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.domain.FileData;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.html.HtmlResource;
import com.groupdocs.viewer.domain.html.HtmlResourceType;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.domain.options.DocumentInfoOptions;
import com.viewer.ViewerUtils;
import com.viewer.model.*;
import com.viewer.model.helper.DotNetToJavaStringHelper;
import com.viewer.model.helper.ImageUrlHelper;
import com.viewer.model.helper.RefObject;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;


public class ViewDocument {

    final ReentrantLock lock = new ReentrantLock();
    List<String> temp_cssList;
    private InputStream result;

    public String execute() throws Throwable {

        HttpServletRequest request = ServletActionContext.getRequest();
        ViewDocumentParameters params = new ObjectMapper().readValue(request.getInputStream(), ViewDocumentParameters.class);

        ViewDocumentResponse viewDocResp = new ViewDocumentResponse();
        FileData fileData = null;
        fileData = ViewerUtils.factoryFileData(params.getPath());
        DocumentInfoContainer docInfo = null;

        viewDocResp.setDocumentDescription((new FileDataJsonSerializer(fileData, new FileDataOptions())).Serialize(false));

        if (params.getUseHtmlBasedEngine()) {
            docInfo = ViewerUtils.getViewerHtmlHandler().getDocumentInfo(new DocumentInfoOptions(params.getPath()));

            viewDocResp.setPageCss(new String[0]);
            viewDocResp.setLic(true);
            viewDocResp.setPdfDownloadUrl(GetPdfDownloadUrl(params));
            viewDocResp.setPdfPrintUrl(GetPdfPrintUrl(params));
            viewDocResp.setUrl(GetFileUrl(params));
            viewDocResp.setPath(params.getPath());
            viewDocResp.setName(params.getPath());
            viewDocResp.setDocType(docInfo.getDocumentType());
            viewDocResp.setFileType(docInfo.getFileType());

            HtmlOptions htmlOptions = new HtmlOptions();
            htmlOptions.setResourcesEmbedded(false);

            htmlOptions.setHtmlResourcePrefix("/GetResourceForHtml?documentPath=" + params.getPath() + "&pageNumber={page-number}&resourceName=");

            if (!DotNetToJavaStringHelper.isNullOrEmpty(params.getPreloadPagesCount().toString())
                    && params.getPreloadPagesCount().intValue() > 0) {
                htmlOptions.setPageNumber(1);
                htmlOptions.setCountPagesToRender(params.getPreloadPagesCount().intValue());
            }

            String[] cssList = null;

            RefObject<ArrayList<String>> tempRef_cssList = new RefObject<ArrayList<String>>(cssList);

            List<PageHtml> htmlPages = null;
            htmlPages = GetHtmlPages(params.getPath(), htmlOptions);
            cssList = tempRef_cssList.argValue;

            ArrayList<String> pagesContent = new ArrayList<String>();
            for (PageHtml page : htmlPages) {
                pagesContent.add(page.getHtmlContent());
            }
            String[] htmlContent = pagesContent.toArray(new String[0]);
            viewDocResp.setPageHtml(htmlContent);
            viewDocResp.setPageCss(new String[]{String.join(" ", temp_cssList)});

            for (int i = 0; i < viewDocResp.getPageHtml().length; i++) {
                String html = viewDocResp.getPageHtml()[i];
                int indexOfScript = html.indexOf("script");
                if (indexOfScript > 0) {
                    viewDocResp.getPageHtml()[i] = html.substring(0, indexOfScript);
                }
            }

        } else {


            docInfo = ViewerUtils.getViewerImageHandler().getDocumentInfo(new DocumentInfoOptions(params.getPath()));

            int maxWidth = 0;
            int maxHeight = 0;
            for (PageData pageData : docInfo.getPages()) {
                if (pageData.getHeight() > maxHeight) {
                    maxHeight = pageData.getHeight();
                    maxWidth = pageData.getWidth();
                }
            }

            fileData.setDateCreated(new Date());
            fileData.setDateModified(docInfo.getLastModificationDate());
            fileData.setPageCount(docInfo.getPages().size());
            fileData.setPages(docInfo.getPages());
            fileData.setMaxWidth(maxWidth);
            fileData.setMaxHeight(maxHeight);

            viewDocResp.setPageCss(new String[0]);
            viewDocResp.setLic(true);
            viewDocResp.setPdfDownloadUrl(GetPdfDownloadUrl(params));
            viewDocResp.setPdfPrintUrl(GetPdfPrintUrl(params));
            viewDocResp.setUrl(GetFileUrl(params.getPath(), true, false, params.getFileDisplayName(),
                    params.getWatermarkText(), params.getWatermarkColor(), params.getWatermarkPostion(),
                    params.getWatermarkWidth(), params.getIgnoreDocumentAbsence(), params.getUseHtmlBasedEngine(),
                    params.getSupportPageRotation()));
            viewDocResp.setPath(params.getPath());
            viewDocResp.setName(params.getPath());

            viewDocResp.setDocType(docInfo.getDocumentType());
            viewDocResp.setFileType(docInfo.getFileType());

            int[] pageNumbers = new int[docInfo.getPages().size()];
            int count = 0;
            for (PageData page : docInfo.getPages()) {

                pageNumbers[count] = page.getNumber();
                count++;
            }
            String applicationHost = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort();
            String[] imageUrls = ImageUrlHelper.GetImageUrls(applicationHost, pageNumbers, params);

            viewDocResp.setImageUrls(imageUrls);


        }

        this.result = new ByteArrayInputStream(new ObjectMapper().writeValueAsString(viewDocResp).getBytes());
        return "success";
    }

    public InputStream getResult() {
        return this.result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public final String GetFileUrl(String path, boolean getPdf, boolean isPrintable, String fileDisplayName,

                                   String watermarkText, Integer watermarkColor, WatermarkPosition watermarkPosition, Float watermarkWidth,
                                   boolean ignoreDocumentAbsence, boolean useHtmlBasedEngine, boolean supportPageRotation) {
        Map<String, String> queryString = new LinkedHashMap<String, String>();
        String myUrl = "path=" + path;

        queryString.put("path", path);

        if (!isPrintable) {
            queryString.put("getPdf", String.valueOf(getPdf).toLowerCase());
            myUrl = myUrl + "&getPdf=" + String.valueOf(getPdf).toLowerCase();

            if (fileDisplayName != null) {
                queryString.put("displayName", fileDisplayName);
            }
        }

        if (watermarkText != null) {
            queryString.put("watermarkText", watermarkText);
            queryString.put("watermarkColor", watermarkColor.toString());

            if (watermarkPosition != null) {
                queryString.put("watermarkPosition", watermarkPosition.toString());
            }

            if (watermarkWidth != null) {
                queryString.put("watermarkWidth", (new Float((float) watermarkWidth)).toString());
            }
        }

        if (ignoreDocumentAbsence) {
            queryString.put("ignoreDocumentAbsence", String.valueOf(ignoreDocumentAbsence).toLowerCase());
        }

        queryString.put("useHtmlBasedEngine", String.valueOf(useHtmlBasedEngine).toLowerCase());
        myUrl = myUrl + "&useHtmlBasedEngine=" + String.valueOf(useHtmlBasedEngine).toLowerCase();
        queryString.put("supportPageRotation", String.valueOf(supportPageRotation).toLowerCase());
        myUrl = myUrl + "&supportPageRotation=" + String.valueOf(supportPageRotation).toLowerCase();
        String handlerName = isPrintable ? "GetPdfWithPrintDialog" : "GetFile";
        String baseUrl = "http://localhost:8080/" + handlerName + "?" + myUrl;
        String fileUrl = baseUrl + handlerName + queryString;
        return baseUrl;
    }

    public String GetPdfDownloadUrl(ViewDocumentParameters parameters) {
        return GetFileUrl(parameters.getPath(), true, false, parameters.getFileDisplayName(),
                parameters.getWatermarkText(), parameters.getWatermarkColor(), parameters.getWatermarkPostion(),
                parameters.getWatermarkWidth(), parameters.getIgnoreDocumentAbsence(),
                parameters.getUseHtmlBasedEngine(), parameters.getSupportPageRotation());

    }

    private String GetPdfPrintUrl(ViewDocumentParameters request) {
        return GetFileUrl(request.getPath(), true, true, request.getFileDisplayName(), request.getWatermarkText(),
                request.getWatermarkColor(), request.getWatermarkPostion(), request.getWatermarkWidth(),
                request.getIgnoreDocumentAbsence(), request.getUseHtmlBasedEngine(), request.getSupportPageRotation());
    }

    private String GetFileUrl(ViewDocumentParameters request) {
        return GetFileUrl(request.getPath(), false, false, request.getFileDisplayName(), null, null, null, null, false,
                false, false);
    }

    private List<PageHtml> GetHtmlPages(String filePath, HtmlOptions htmlOptions) throws Throwable {

        List<PageHtml> htmlPages = null;
        try {
            ViewerUtils.getViewerHtmlHandler().getPages(filePath, htmlOptions);
        } catch (Exception x) {
            throw new ServletException(x);
        }
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
