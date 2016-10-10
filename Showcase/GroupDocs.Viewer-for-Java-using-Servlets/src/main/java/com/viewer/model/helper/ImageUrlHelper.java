package com.viewer.model.helper;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpUtils;

import com.groupdocs.viewer.domain.WatermarkPosition;
import com.viewer.model.GetImageUrlsParameters;
import com.viewer.model.ViewDocumentParameters;

public final class ImageUrlHelper
 {
		public static String[] GetImageUrls(String applicationHost, int[] pageNumbers, GetImageUrlsParameters parameters)
		{
			return GetImageUrls(applicationHost,
					parameters.getPath(),
					parameters.getFirstPage(), 
					pageNumbers.length, 
					parameters.getWidth(), 
					parameters.getQuality(), 
					parameters.getUsePdf(), 
					parameters.getWatermarkText(), 
					parameters.getWatermarkColor(), 
					parameters.getWatermarkPostion(), 
					parameters.getWatermarkWidth(), 
					parameters.getIgnoreDocumentAbsence(), 
					parameters.getUseHtmlBasedEngine(), 
					parameters.getSupportPageRotation(), 
					parameters.getInstanceIdToken(), 
					null, pageNumbers);
		}
		public static String[] GetImageUrls(String applicationHost, int[] pageNumbers, ViewDocumentParameters parameters)
		{
			return GetImageUrls(applicationHost,
					parameters.getPath(),
					0, 
					pageNumbers.length, 
					parameters.getWidth(), 
					parameters.getQuality(), 
					parameters.getUsePdf(), 
					parameters.getWatermarkText(), 
					parameters.getWatermarkColor(), 
					parameters.getWatermarkPostion(), 
					parameters.getWatermarkWidth(), 
					parameters.getIgnoreDocumentAbsence(), 
					parameters.getUseHtmlBasedEngine(), 
					parameters.getSupportPageRotation(), 
					parameters.getInstanceIdToken(), 
					null, pageNumbers);
		}
		 private static String[] GetImageUrls(String applicationHost, String path, int startingPageNumber, int pageCount, Integer pageWidth, Integer quality, boolean usePdf, String watermarkText, Integer watermarkColor, com.viewer.model.WatermarkPosition watermarkPosition, Float watermarkWidth, boolean ignoreDocumentAbsence, boolean useHtmlBasedEngine, boolean supportPageRotation, String instanceId, String locale, int[] pageNumbers)
		 {
					String[] pageUrls = new String[pageCount];
					 HashMap<String, Object> routeValueDictionary2 = new HashMap<String, Object>();
					 	if(quality== null)
					 		quality = 0;
						routeValueDictionary2.put("path", path);
						routeValueDictionary2.put("width", pageWidth);
						routeValueDictionary2.put("quality", quality);
						routeValueDictionary2.put("usePdf", usePdf);
						routeValueDictionary2.put("useHtmlBasedEngine", useHtmlBasedEngine);
						routeValueDictionary2.put("rotate", supportPageRotation);
						routeValueDictionary2.put("pageIndex", null);

						if (!com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrWhiteSpace(locale))
						{
							routeValueDictionary2.put("locale", locale);
						}

						if (!com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrEmpty(watermarkText))
						{
							routeValueDictionary2.put("watermarkText", watermarkText);
							routeValueDictionary2.put("watermarkColor", watermarkColor);
							routeValueDictionary2.put("watermarkPosition", watermarkPosition);
							routeValueDictionary2.put("watermarkWidth", watermarkWidth);
						}

						if (!com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrWhiteSpace(instanceId))
						{
							routeValueDictionary2.put("instanceIdToken", instanceId);
						}
						if (ignoreDocumentAbsence)
						{
							routeValueDictionary2.put("ignoreDocumentAbsence", ignoreDocumentAbsence);
						}


						if (pageNumbers != null)
						{
							for (int i = 0; i < pageCount; i++)
							{
								routeValueDictionary2.put("pageindex", pageNumbers[i] - 1);
								//pageUrls[i] = ConvertUrlToAbsolute(applicationHost, CreateRelativeRequestUrl("GetDocumentPageImage", routeValueDictionary2));
								pageUrls[i] = applicationHost + CreateRelativeRequestUrl("GetDocumentPageImage", routeValueDictionary2);

							}
						}
						else
						{
							for (int i = 0; i < pageCount; i++)
							{
								routeValueDictionary2.put("pageindex", startingPageNumber + i);
								//pageUrls[i] = ConvertUrlToAbsolute(applicationHost, CreateRelativeRequestUrl("GetDocumentPageImage", routeValueDictionary2));
								pageUrls[i] = applicationHost + CreateRelativeRequestUrl("GetDocumentPageImage", routeValueDictionary2);
							}
						}
						return pageUrls;
		 }
		  private static String ConvertUrlToAbsolute(String applicationHost, String inputUrl)
		  {
					String result = String.format("{0}{1}", applicationHost, inputUrl);
					return result;
		  }
		 private static String CreateRelativeRequestUrl(String actionName, HashMap<String, Object> routeValueDictionary2)
		 {
					StringBuilder urlBuilder = new StringBuilder("/");
					urlBuilder.append(actionName);
					if (routeValueDictionary2.isEmpty())
					{
						return urlBuilder.toString();
					}
					urlBuilder.append("?");
					for (Map.Entry<String, Object> oneRoute : routeValueDictionary2.entrySet())
					{
						if (com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrWhiteSpace(oneRoute.getKey()) || oneRoute.getValue() == null || com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrWhiteSpace(oneRoute.getValue().toString()))
						{
							continue;
						}
						urlBuilder.append(oneRoute.getKey());
						urlBuilder.append("=");
						String originalValue = oneRoute.getValue().toString();
						String encodedValue = URLEncoder.encode(originalValue).toString();
						urlBuilder.append(encodedValue);
						urlBuilder.append("&");
					}
					String trimUrl = urlBuilder.toString();
					trimUrl = trimUrl.trim();
					trimUrl = removeLastChar(trimUrl);
					/*int checkLength = trimUrl.length();
					trimUrl.charAt(checkLength); //remove last character '&'
					*/return trimUrl;
		 }
		 private static String removeLastChar(String str) {
		        return str.substring(0,str.length()-1);
		    }
 }