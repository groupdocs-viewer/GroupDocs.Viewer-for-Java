package com.groupdocs.ui;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletResponse;

import org.apache.commons.io.IOUtils;

import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.AttachmentBase;
import com.groupdocs.viewer.domain.Watermark;
import com.groupdocs.viewer.domain.WatermarkPosition;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.domain.image.PageImage;
import com.groupdocs.viewer.exception.ArgumentOutOfRangeException;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;
import com.groupdocs.viewer.handler.ViewerImageHandler;
import com.groupdocs.viewer.licensing.License;

public class Utils {
    static {
        // Load the license as early as possible
        loadLicense();
    }

    public static ViewerConfig createViewerConfig() {
        ViewerConfig cfg = new ViewerConfig();
        cfg.setStoragePath(getProjectProperty("storage.path"));
        cfg.setCachePath(getProjectProperty("cache.path"));
        cfg.setTempPath(getProjectProperty("temp.path"));
        cfg.setUseCache(false);
        return cfg;
    }

    public static ViewerImageHandler createViewerImageHandler() {
        ViewerImageHandler handler = new ViewerImageHandler(createViewerConfig());
        return handler;
    }

    public static ViewerHtmlHandler createViewerHtmlHandler() {
        ViewerHtmlHandler handler = new ViewerHtmlHandler(createViewerConfig());
        return handler;
    }
    
    public synchronized static List<PageImage> loadPageImageList(ViewerImageHandler handler, String filename) {
        try {
            return handler.getPages(filename);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }

    public synchronized static List<PageImage> loadPageImageList(ViewerImageHandler handler, String filename, ImageOptions options) {
        try {
            return handler.getPages(filename, options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }

    public static List<PageHtml> loadPageHtmlList(ViewerHtmlHandler handler, String filename) {
        try {
            return handler.getPages(filename);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }
    
    public static List<PageHtml> loadPageHtmlList(ViewerHtmlHandler handler, String filename, HtmlOptions options) {
        try {
            return handler.getPages(filename, options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }
    
    public synchronized static List<PageImage> loadPageImageListFromAttachment(ViewerImageHandler handler, AttachmentBase attachment) {
        try {
            return handler.getPages(attachment);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }
    
    public synchronized static List<PageImage> loadPageImageListFromAttachment(ViewerImageHandler handler, AttachmentBase attachment, ImageOptions options) {
        try {
            return handler.getPages(attachment, options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }
    
    public static List<PageHtml> loadPageHtmlListFromAttachment(ViewerHtmlHandler handler, AttachmentBase attachment) {
        try {
            return handler.getPages(attachment);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }
    
    public static List<PageHtml> loadPageHtmlListFromAttachment(ViewerHtmlHandler handler, AttachmentBase attachment, HtmlOptions options) {
        try {
            return handler.getPages(attachment, options);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }

    public static void loadLicense() {
        License l = new License();
        if (Files.exists(FileSystems.getDefault().getPath(getProjectProperty("license.path")))) {
            l.setLicense(getProjectProperty("license.path"));
            
        }
    }

    public static String getProjectProperty(String name) {
        Properties p = new Properties();
        try (InputStream i = Utils.class.getResourceAsStream("/project.properties")) {
            p.load(i);
        } catch (IOException e) {
            // Ignore
        }
        return p.getProperty(name);
    }

    public static int copyStream(InputStream input, OutputStream output) {
        try {
            return IOUtils.copy(input, output);
        } catch (IOException x) {
            throw new UncheckedIOException(x);
        }
    }

    public static int writeToResponse(InputStream input, ServletResponse response) {
        try {
            return Utils.copyStream(input, response.getOutputStream());
        } catch (IOException x) {
            throw new UncheckedIOException(x);
        }
    }
    public static boolean isValidUrl(String urlToValidate){    	
    	try {
	        URL url = new URL(urlToValidate);
	        url.toURI();
	        return true;
	    } catch (Exception exception){
	        return false;
	    }
		
    }
    public static String downloadToStorage(String url) throws IOException{
    	ViewerConfig vconfig = createViewerConfig();
    	String fileNameFromUrl = getFilenameFromUrl(url);  
		String fileNameWithPath  = vconfig.getStoragePath() + File.separator + fileNameFromUrl;
		downloadFile(url, fileNameWithPath);   
    	return fileNameFromUrl;
    }
    public static String getFilenameFromUrl(String name){
      String filename = name.replaceAll("[^a-zA-Z0-9.-]", "_");
    
      final int maxFilenameLength = 200;
      int length = filename.length();
      if (length > maxFilenameLength)
    	  length = maxFilenameLength;
   
      filename = filename.substring(0, length);
   
      filename = filename.replace("___", "_");
      filename = filename.replace("__", "_");
      //System.out.println("filenamefilename:"+filename);
      return filename;
	}
    
    public static void downloadFile(String sourceURL,String fileNameWithPath) throws IOException{	
		final int BUFFER_SIZE = 4096;
		URL url = new URL(sourceURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		int responseCode = httpConn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			String fileName = "";
			String disposition = httpConn.getHeaderField("Content-Disposition");
			String contentType = httpConn.getContentType();
			int contentLength = httpConn.getContentLength();

			if (disposition != null) {
				int index = disposition.indexOf("file=");
				if (index > 0)
					fileName = disposition.substring(index + 10,disposition.length() - 1);				
			} else {
				fileName = sourceURL.substring(sourceURL.lastIndexOf("/") + 1,sourceURL.length());
			}
			InputStream inputStream = httpConn.getInputStream();
			FileOutputStream outputStream = new FileOutputStream(fileNameWithPath);

			int bytesRead = -1;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			outputStream.close();
			inputStream.close();
		} 
		httpConn.disconnect();
	}
    
    public static Watermark getWatermark(String watermarkText,String watermarkColor,String watermarkPosition,
    		String watermarkWidth){
        Watermark watermark = new Watermark(watermarkText);
        //Set color for watermark with values Red, Green, Blue and Alpha(Transparency)
        watermark.setColor(new Color(Integer.valueOf(watermarkColor)));
		watermark.setPosition(toWatermarkPosition(watermarkPosition));
		watermark.setWidth(Float.valueOf(watermarkWidth));
		watermark.setFontName("MS Gothic");
    	return watermark;
    }
    
    private static WatermarkPosition toWatermarkPosition(String watermarkPosition){
    	if(watermarkPosition!=null && watermarkPosition.length()>0){
    		switch (watermarkPosition){
    			case "Diagonal":
    				return WatermarkPosition.Diagonal;
    			case "TopLeft":
    				return WatermarkPosition.TopLeft;
    			case "TopCenter":
    				return WatermarkPosition.TopCenter;
    			case"TopRight":
    				return WatermarkPosition.TopRight;
    			case "BottomLeft":
    				return WatermarkPosition.BottomLeft;
    			case "BottomCenter":
    				return WatermarkPosition.BottomCenter;
    			case "BottomRight":
    				return WatermarkPosition.BottomRight; 
    			default:
    				throw new ArgumentOutOfRangeException();
    		}
		}else
			return WatermarkPosition.Diagonal;  
    }
}

