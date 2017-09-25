package com.viewer.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewer.model.ViewDocumentParameters;
import com.viewer.model.WatermarkPosition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by saqib on 22/07/2016.
 */
@WebServlet("/GetPdfPrintUrl")
public class GetPdfPrintUrl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.addHeader("Content-Type", "application/json");
        ViewDocumentParameters parameters = new ObjectMapper().readValue(request.getInputStream(), ViewDocumentParameters.class);


        String r = GetFileUrl(parameters.getPath(), true, true, parameters.getFileDisplayName(), parameters.getWatermarkText(),
                parameters.getWatermarkColor(), parameters.getWatermarkPostion(), parameters.getWatermarkWidth(),
                parameters.getIgnoreDocumentAbsence(), parameters.getUseHtmlBasedEngine(), parameters.getSupportPageRotation());

        response.getWriter().print(r);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
