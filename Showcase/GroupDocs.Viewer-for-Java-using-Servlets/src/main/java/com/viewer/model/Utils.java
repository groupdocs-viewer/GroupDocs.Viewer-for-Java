package com.viewer.model;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.WatchEvent.Kind;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.Document;
import javax.swing.text.Element;

import org.apache.taglibs.standard.extra.spath.Path;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.domain.Watermark;
import com.groupdocs.viewer.domain.html.HtmlResourceType;
import com.viewer.model.helper.DotNetToJavaStringHelper;

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class Utils {
	@SuppressWarnings("static-access")
	public static ArrayList<FileBrowserTreeNode> ToFileTreeNodes(String path, List<FileDescription> list) {
		ArrayList<FileBrowserTreeNode> tempVar1 = new ArrayList<FileBrowserTreeNode>();

		for (FileDescription nodes : list) {
			
			FileBrowserTreeNode tempVar = new FileBrowserTreeNode();

			tempVar.path = com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrEmpty(path) ? nodes.getName()
					: String.format("%1$s/%2$s", path, nodes.getName());
			tempVar.docType = com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrEmpty(nodes.getDocumentType())
					? nodes.getDocumentType() : nodes.getDocumentType().toLowerCase();
			tempVar.fileType = com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrEmpty(nodes.getFileType())
					? nodes.getFileType() : nodes.getFileType().toLowerCase();
			tempVar.name = nodes.getName();
			tempVar.size = nodes.getSize();
			tempVar.modifyTime = nodes.getLastModificationDate();
			tempVar.type = nodes.getName().contains(".") ? "file" : "folder";
			tempVar1.add(tempVar);

		}
		return tempVar1;
	}

	public static Watermark GetWatermark(String watermarkText, Integer watermarkColor,
			WatermarkPosition watermarkPosition, Float watermarkWidth) {
		if (com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrWhiteSpace(watermarkText)) {
			return null;
		}
		Color c = null;
		if (watermarkColor != null) {
			c = new Color(watermarkColor.intValue());
		}

		Watermark tempVar = new Watermark(watermarkText);
		tempVar.setColor(watermarkColor != null ? c : Color.RED);
		tempVar.setPosition(ToWatermarkPosition(watermarkPosition));
		tempVar.setWidth(watermarkWidth);
		return tempVar;
	}

	private static int ToWatermarkPosition(
			WatermarkPosition watermarkPosition) {
		if (watermarkPosition == null) {
			return com.groupdocs.viewer.domain.WatermarkPosition.Diagonal;
		}
		switch (watermarkPosition.getValue()) {
		case 1:
			return com.groupdocs.viewer.domain.WatermarkPosition.Diagonal;
		case 2:
			return com.groupdocs.viewer.domain.WatermarkPosition.TopLeft;
		case 3:
			return com.groupdocs.viewer.domain.WatermarkPosition.TopCenter;
		case 4:
			return com.groupdocs.viewer.domain.WatermarkPosition.TopRight;
		case 5:
			return com.groupdocs.viewer.domain.WatermarkPosition.BottomLeft;
		case 6:
			return com.groupdocs.viewer.domain.WatermarkPosition.BottomCenter;
		case 7:
			return com.groupdocs.viewer.domain.WatermarkPosition.BottomRight;
		default:
			throw new IllegalArgumentException();
		}
	}

	private static String getFileExtension(String fileName) {
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public static HtmlResourceType GetResourceType(String resourceName) {
		String fileExtension = getFileExtension(resourceName);
		if (!DotNetToJavaStringHelper.isNullOrWhiteSpace(fileExtension) && fileExtension.startsWith(".")) {
			fileExtension = DotNetToJavaStringHelper.remove(fileExtension, 0, 1);
		}
		if (fileExtension == "svg")
			return HtmlResourceType.Image;
		else if (fileExtension == "css")
			return HtmlResourceType.Image;
		else if (fileExtension == "woff")
			return HtmlResourceType.Image;
		else {
			return HtmlResourceType.Image;
		}
	}

	public static ArrayList<String> GetCssClasses(String pageHtml) {

		ArrayList<String> classes = new ArrayList<String>();
		classes.add("awdiv");
		classes.add("awpage");
		classes.add("awspan");
		classes.add("awtext1");
		classes.add("awtext2");

		return new ArrayList(new HashSet(classes)); 
	}

	public static String GetImageMimeTypeFromFilename(String fileName) {
		String fileExtension = getFileExtension(fileName);
		if (!DotNetToJavaStringHelper.isNullOrWhiteSpace(fileExtension) && fileExtension.startsWith(".")) {
			fileExtension = DotNetToJavaStringHelper.remove(fileExtension, 0, 1);
		}
		String mimeType;

		if (fileExtension == "svg")
			mimeType = "image/svg+xml";
		else if (fileExtension == "css")
			mimeType = "text/css";
		else if (fileExtension == "woff")
			mimeType = "application/font-woff";
		else if (fileExtension == "htm")
			mimeType = "text/html";
		else {
			mimeType = String.format("image/%1$s", fileExtension);
		}
		return mimeType;
	}
	
}
