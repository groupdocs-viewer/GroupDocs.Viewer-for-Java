package com.viewer.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewer.model.ViewDocumentParameters;
import com.viewer.model.WatermarkPosition;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetPdfPrintUrl {

    private InputStream result;

    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        response.addHeader("Content-Type", "application/json");
        ViewDocumentParameters parameters = null;
        try {
            parameters = new ObjectMapper().readValue(request.getInputStream(), ViewDocumentParameters.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String r = GetFileUrl(parameters.getPath(), true, true, parameters.getFileDisplayName(), parameters.getWatermarkText(),
                parameters.getWatermarkColor(), parameters.getWatermarkPostion(), parameters.getWatermarkWidth(),
                parameters.getIgnoreDocumentAbsence(), parameters.getUseHtmlBasedEngine(), parameters.getSupportPageRotation());


        this.result = new ByteArrayInputStream(r.getBytes());
        return "success";
    }

    public InputStream getResult() {
        return this.result;
    }

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
}
