package com.viewer.controller;

import java.awt.DisplayMode;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.ResultSet;

import org.apache.commons.io.IOUtils;
import org.apache.taglibs.standard.extra.spath.Path;
import org.eclipse.jetty.http.MetaData.Response;
import org.eclipse.jetty.server.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.converter.options.ConvertImageFileType;
import com.groupdocs.viewer.converter.options.FileDataOptions;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.FileData;
import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.Transformation;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.containers.FileContainer;
import com.groupdocs.viewer.domain.containers.FileTreeContainer;
import com.groupdocs.viewer.domain.containers.RotatePageContainer;
import com.groupdocs.viewer.domain.html.HtmlResource;
import com.groupdocs.viewer.domain.html.HtmlResourceType;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.domain.image.PageImage;
import com.groupdocs.viewer.domain.options.DocumentInfoOptions;
import com.groupdocs.viewer.domain.options.FileTreeOptions;
import com.groupdocs.viewer.domain.options.PdfFileOptions;
import com.groupdocs.viewer.domain.options.RotatePageOptions;
import com.groupdocs.viewer.handler.ViewerHandler;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;
import com.groupdocs.viewer.handler.ViewerImageHandler;
import com.groupdocs.viewer.licensing.License;
import com.viewer.model.*;
import com.viewer.model.helper.*;

@Controller
public class ViewerController {
	private static ViewerHtmlHandler _htmlHandler;
	private static ViewerImageHandler _imageHandler;

	private final ConvertImageFileType _convertImageFileType = ConvertImageFileType.JPG;
	public String _licensePath = "E:\\GroupDocs.Total.Java.lic";
	private static String _storagePath = (System.getProperty("user.dir") + "\\src\\main\\webapp\\storage\\")
			.replace("\\", "/");
	private static String _tempPath = (System.getProperty("user.dir") + "\\src\\main\\webapp\\storage\\temp\\")
			.replace("\\", "/");
	private static String _locales = (System.getProperty("user.dir") + "\\src\\main\\webapp\\storage\\temp\\")
			.replace("\\", "/");
	List<String> temp_cssList;
	final ReentrantLock lock = new ReentrantLock();

	public ViewerController() {

		ViewerConfig htmlConfig = new ViewerConfig();
		htmlConfig.setStoragePath(_storagePath);
		htmlConfig.setTempPath(_tempPath);
		htmlConfig.setUseCache(true);

		_htmlHandler = new ViewerHtmlHandler(htmlConfig);

		ViewerConfig imageConfig = new ViewerConfig();
		imageConfig.setStoragePath(_storagePath);
		imageConfig.setTempPath(_tempPath);
		imageConfig.setUseCache(true);
		_imageHandler = new ViewerImageHandler(imageConfig);
	}

	@RequestMapping("/action")
	public ModelAndView redirectToViewer() {

		ModelAndView mv = new ModelAndView("document-viewer");

		return mv;
	}

	@RequestMapping(value = "/ViewDocument", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public ViewDocumentResponse viewDoc(@RequestBody ViewDocumentParameters params, HttpServletRequest request)
			throws Exception {
		// To Set License
		License lic = new License();
		lic.setLicense(_licensePath);
		params.setUseHtmlBasedEngine(true);
		if (params.getUseHtmlBasedEngine()) {

			DocumentInfoContainer docInfo = _htmlHandler.getDocumentInfo(new DocumentInfoOptions(params.getPath()));
			int maxWidth = 0;
			int maxHeight = 0;
			for (PageData pageData : docInfo.getPages()) {
				if (pageData.getHeight() > maxHeight) {
					maxHeight = pageData.getHeight();
					maxWidth = pageData.getWidth();
				}
			}
			FileData fileData = new FileData();

			fileData.setDateCreated(new Date());
			fileData.setDateModified(docInfo.getLastModificationDate());
			fileData.setPageCount(docInfo.getPages().size());
			fileData.setPages(docInfo.getPages());
			fileData.setMaxWidth(maxWidth);
			fileData.setMaxHeight(maxHeight);

			ViewDocumentResponse result = new ViewDocumentResponse();
			result.setPageCss(new String[0]);
			result.setLic(true);
			result.setPdfDownloadUrl(GetPdfDownloadUrl(params));
			result.setPdfPrintUrl(GetPdfPrintUrl(params));
			result.setUrl(GetFileUrl(params));
			result.setPath(params.getPath());
			result.setName(params.getPath());
			try {
				result.setDocumentDescription((new FileDataJsonSerializer(fileData, new FileDataOptions())).Serialize(false));
				}
			catch (ParseException x) {
				throw new ServletException(x);
				}
			result.setDocumentDescription(
					(new FileDataJsonSerializer(fileData, new FileDataOptions())).Serialize(false));
			result.setDocType(docInfo.getDocumentType());
			result.setFileType(docInfo.getFileType());

			HtmlOptions htmlOptions = new HtmlOptions();
			htmlOptions.setResourcesEmbedded(true);

			htmlOptions.setHtmlResourcePrefix(
					"/GetResourceForHtml?documentPath=" + params.getPath() + "&pageNumber={page-number}&resourceName=");

			if (!DotNetToJavaStringHelper.isNullOrEmpty(params.getPreloadPagesCount().toString())
					&& params.getPreloadPagesCount().intValue() > 0) {
				htmlOptions.setPageNumber(1);
				htmlOptions.setCountPagesToConvert(params.getPreloadPagesCount().intValue());
			}

			String[] cssList = null;

			RefObject<ArrayList<String>> tempRef_cssList = new RefObject<ArrayList<String>>(cssList);

			List<PageHtml> htmlPages = GetHtmlPages(params.getPath(), htmlOptions);
			cssList = tempRef_cssList.argValue;

			ArrayList<String> pagesContent = new ArrayList<String>();
			for (PageHtml page : htmlPages) {
				pagesContent.add(page.getHtmlContent());
			}
			String[] htmlContent = pagesContent.toArray(new String[0]);
			result.setPageHtml(htmlContent);
			result.setPageCss(new String[] { String.join(" ", temp_cssList) });

			for (int i = 0; i < result.getPageHtml().length; i++) {
				String html = result.getPageHtml()[i];
				int indexOfScript = html.indexOf("script");
				if (indexOfScript > 0) {
					result.getPageHtml()[i] = html.substring(0, indexOfScript);
				}
			}

			return result;

		} else {

			DocumentInfoContainer docInfo = _imageHandler.getDocumentInfo(new DocumentInfoOptions(params.getPath()));
			int maxWidth = 0;
			int maxHeight = 0;
			for (PageData pageData : docInfo.getPages()) {
				if (pageData.getHeight() > maxHeight) {
					maxHeight = pageData.getHeight();
					maxWidth = pageData.getWidth();
				}
			}
			FileData fileData = new FileData();

			fileData.setDateCreated(new Date());
			fileData.setDateModified(docInfo.getLastModificationDate());
			fileData.setPageCount(docInfo.getPages().size());
			fileData.setPages(docInfo.getPages());
			fileData.setMaxWidth(maxWidth);
			fileData.setMaxHeight(maxHeight);

			ViewDocumentResponse result = new ViewDocumentResponse();
			result.setPageCss(new String[0]);
			result.setLic(true);
			result.setPdfDownloadUrl(GetPdfDownloadUrl(params));
			result.setPdfPrintUrl(GetPdfPrintUrl(params));
			params.setUseHtmlBasedEngine(true);
			result.setUrl(GetFileUrl(params.getPath(), true, false, params.getFileDisplayName(),
					params.getWatermarkText(), params.getWatermarkColor(), params.getWatermarkPostion(),
					params.getWatermarkWidth(), params.getIgnoreDocumentAbsence(), params.getUseHtmlBasedEngine(),
					params.getSupportPageRotation()));
			result.setPath(params.getPath());
			result.setName(params.getPath());
			result.setDocumentDescription(
					(new FileDataJsonSerializer(fileData, new FileDataOptions())).Serialize(false));
			result.setDocType(docInfo.getDocumentType());
			result.setFileType(docInfo.getFileType());

			int[] pageNumbers = new int[docInfo.getPages().size()];
			int count = 0;
			for (PageData page : docInfo.getPages()) {

				pageNumbers[count] = page.getNumber();
				count++;
			}
			String applicationHost = request.getScheme() + "://" + request.getServerName() + ":"
					+ request.getServerPort();
			String[] imageUrls = ImageUrlHelper.GetImageUrls(applicationHost, pageNumbers, params);

			result.setImageUrls(imageUrls);
			return result;

		}

	}

	private String GetFileUrl(ViewDocumentParameters request) {
		return GetFileUrl(request.getPath(), false, false, request.getFileDisplayName(), null, null, null, null, false,
				false, false);
	}

	@RequestMapping(value = "/LoadFileBrowserTreeData", method = RequestMethod.POST, headers = {
			"Content-type=application/json" })
	@ResponseBody
	public FileBrowserTreeDataResponse loadFileBrowserTreeData(
			@RequestBody LoadFileBrowserTreeDataParameters parameters, HttpServletRequest request) throws Exception {
		String path = _storagePath;
		try {

			if (!StringUtils.isEmpty(parameters.getPath()))
				path = path + parameters.getPath();

			FileTreeOptions options = new FileTreeOptions(path);
			FileTreeContainer tree = _htmlHandler.loadFileTree(options);

			FileBrowserTreeDataResponse result = new FileBrowserTreeDataResponse();
			result.setNodes(Utils.ToFileTreeNodes(parameters.getPath(), tree.getFileTree()));
			List<FileDescription> mytree = tree.getFileTree();
			result.setCount(mytree.size());
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		FileBrowserTreeDataResponse result = new FileBrowserTreeDataResponse();
		return result;

	}

	@RequestMapping(value = "/GetImageUrls", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody

	public GetImageUrlsResponse GetImageUrls(@RequestBody GetImageUrlsParameters parameters, HttpServletRequest request)
			throws Exception {

		try {

			if (com.viewer.model.helper.DotNetToJavaStringHelper.isNullOrEmpty(parameters.getPath())) {
				GetImageUrlsResponse empty = new GetImageUrlsResponse();
				empty.imageUrls = new String[0];
				return empty;
			}

			DocumentInfoOptions documentInfoOptions = new DocumentInfoOptions(parameters.getPath());
			DocumentInfoContainer documentInfoContainer = _imageHandler.getDocumentInfo(documentInfoOptions);

			int[] pageNumbers = new int[documentInfoContainer.getPages().size()];
			int count = 0;
			for (PageData page : documentInfoContainer.getPages()) {

				pageNumbers[count] = page.getNumber();
				count++;
			}

			String applicationHost = request.getScheme() + "://" + request.getServerName() + ":"
					+ request.getServerPort();
			String[] imageUrls = ImageUrlHelper.GetImageUrls(applicationHost, pageNumbers, parameters);

			GetImageUrlsResponse result = new GetImageUrlsResponse();
			result.imageUrls = imageUrls;
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		GetImageUrlsResponse test = null;
		return test;
	}

	public String removeExtention(String filePath) {
		// These first few lines the same as Justin's
		File f = new File(filePath);

		// if it's a directory, don't remove the extention
		if (f.isDirectory())
			return filePath;

		String name = f.getName();

		// Now we know it's a file - don't need to do any special hidden
		// checking or contains() checking because of:
		final int lastPeriodPos = name.lastIndexOf('.');
		if (lastPeriodPos <= 0) {
			// No period after first character - return name as it was passed in
			return filePath;
		} else {
			// Remove the last period and everything after it
			File renamed = new File(f.getParent(), name.substring(0, lastPeriodPos));
			return renamed.getPath();
		}
	}

	@RequestMapping(value = "/GetResourceForHtml")
	@ResponseBody
	public ResponseEntity<InputStreamResource> GetResourceForHtml(@RequestParam String documentPath, int pageNumber,
			String resourceName) {
		if (!DotNetToJavaStringHelper.isNullOrEmpty(resourceName) && resourceName.indexOf("/") >= 0) {
			resourceName = resourceName.replace("/", "");
		}

		HtmlResource resource = new HtmlResource();
		resource.setResourceName(resourceName);
		resource.setResourceType(Utils.GetResourceType(resourceName));
		resource.setDocumentPageNumber(pageNumber);

		InputStream stream = _htmlHandler.getResource(documentPath, resource);

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(Utils.GetImageMimeTypeFromFilename(resourceName)))
				.body(new InputStreamResource(stream));

	}

	@RequestMapping(value = "/GetPdfWithPrintDialog")
	@ResponseBody
	public ResponseEntity<InputStreamResource> GetPdfWithPrintDialog(@RequestParam String path, Boolean getPdf,
			Boolean useHtmlBasedEngine, Boolean supportPageRotation, HttpServletResponse response) throws Exception {

		PdfFileOptions options = new PdfFileOptions();
		options.setGuid(path);
		options.setAddPrintAction(true);

		FileContainer result = _imageHandler.getPdfFile(options);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
				.body(new InputStreamResource(result.getStream()));
	}

	@RequestMapping(value = "/GetFile")
	@ResponseBody
	private void GetFile(@RequestParam String path, Boolean getPdf, Boolean useHtmlBasedEngine,
			Boolean supportPageRotation, HttpServletResponse response) throws Exception {

		File file = new File(path);

		String displayName = path;
		String nameWithoutExtension = removeExtention(path);
		Stream fileStream;
		File newFile = new File(nameWithoutExtension + ".pdf");

		displayName = newFile.getPath();

		PdfFileOptions options = new PdfFileOptions();
		options.setGuid(path);

		FileContainer pdfFileResponse = _htmlHandler.getPdfFile(options);

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + displayName + "\"");
		InputStream fileIn = pdfFileResponse.getStream();
		ServletOutputStream out = response.getOutputStream();

		byte[] outputByte = new byte[4096];
		while (fileIn.read(outputByte, 0, 4096) != -1) {
			out.write(outputByte, 0, 4096);
		}
		fileIn.close();
		out.flush();
		out.close();

	}

	@RequestMapping(value = "/GetDocumentPageHtml", method = RequestMethod.POST, headers = {
			"Content-type=application/json" })
	@ResponseBody
	public final Map<String, Object> GetDocumentPageHtml(@RequestBody GetDocumentPageHtmlParameters parameters,
			HttpServletRequest request) throws Exception {

		if (DotNetToJavaStringHelper.isNullOrWhiteSpace(parameters.getPath())) {
			System.out.println("A document path must be specified path");
		}

		String[] cssList = null;
		int pageNumber = parameters.getPageIndex() + 1;

		HtmlOptions htmlOptions = new HtmlOptions();
		htmlOptions.setPageNumber(parameters.getPageIndex() + 1);
		htmlOptions.setCountPagesToConvert(1);
		htmlOptions.setResourcesEmbedded(true);
		htmlOptions.setHtmlResourcePrefix(
				"/GetResourceForHtml?documentPath=" + parameters.getPath() + "&pageNumber={page-number}&resourceName=");

		List<PageHtml> htmlPages = GetHtmlPages(parameters.getPath(), htmlOptions);

		String pageHtml = htmlPages.size() > 0 ? htmlPages.get(0).getHtmlContent() : "";
		String[] pageCss = temp_cssList.size() > 0 ? new String[]{String.join(" ", temp_cssList)} : new String[]{};

		Map<String, Object> a = new HashMap<String, Object>();
		a.put("pageHtml", pageHtml);
		a.put("pageCss", pageCss);
		return a;
	}

	private List<PageHtml> GetHtmlPages(String filePath, HtmlOptions htmlOptions) throws Exception {

		List<PageHtml> htmlPages = _htmlHandler.getPages(filePath, htmlOptions);
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

			/////////////////////////

			page.setHtmlContent(strippedHtml);

			for (HtmlResource resource : page.getHtmlResources()) {

				if (resource.getResourceType() == HtmlResourceType.Style) {
					InputStream cssStream = _htmlHandler.getResource(filePath, resource);
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

						String fullPath = _tempPath + filePath + "/" + "html" + "/" + "resources" + "/" + "page"
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

	@RequestMapping(value = "/GetApplicationHost", method = RequestMethod.GET, headers = {
			"Content-type=application/json" })
	@ResponseBody
	private String GetApplicationHost(@RequestBody HttpServletRequest request) {

		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	}

	@RequestMapping(value = "/RotatePage", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public RotatePageResponse rotatePage(@RequestBody RotatePageParameters parameters, HttpServletRequest request)
			throws Exception {

		String guid = parameters.getPath();
		int pageIndex = parameters.getPageNumber();

		DocumentInfoOptions documentInfoOptions = new DocumentInfoOptions(guid);
		DocumentInfoContainer documentInfoContainer = (DocumentInfoContainer) _imageHandler
				.getDocumentInfo(documentInfoOptions);

		List<PageData> pageList = new ArrayList<PageData>();
		pageList = documentInfoContainer.getPages();
		int pageNumber = pageList.indexOf(pageIndex);

		RotatePageOptions rotatePageOptions = new RotatePageOptions(guid, 1, parameters.getRotationAmount());
		RotatePageContainer rotatePageContainer = _imageHandler.rotatePage(rotatePageOptions);
		int currentPage = rotatePageContainer.getCurrentRotationAngle();
		RotatePageResponse response = new RotatePageResponse();
		response.setResultAngle(currentPage);

		return response;
	}

	@RequestMapping(value = "/GetPdfDownloadUrl")
	@ResponseBody
	public String GetPdfDownloadUrl(@RequestBody ViewDocumentParameters parameters) throws Exception {
		return GetFileUrl(parameters.getPath(), true, false, parameters.getFileDisplayName(),
				parameters.getWatermarkText(), parameters.getWatermarkColor(), parameters.getWatermarkPostion(),
				parameters.getWatermarkWidth(), parameters.getIgnoreDocumentAbsence(),
				parameters.getUseHtmlBasedEngine(), parameters.getSupportPageRotation());
	}

	@RequestMapping("/GetDocumentPageImage")
	@ResponseBody
	public final ResponseEntity<InputStreamResource> GetDocumentPageImage(@RequestParam String path, Boolean usePdf,
			Boolean useHtmlBasedEngine, Boolean rotate, int width, int pageindex, int quality) throws Exception {

		lock.lock();
		ViewerConfig imageConfig = new ViewerConfig();
		imageConfig.setStoragePath(_storagePath);
		imageConfig.setTempPath(_tempPath);
		imageConfig.setUseCache(true);
		_imageHandler = new ViewerImageHandler(imageConfig);
		String guid = path;
		int pageIndex = pageindex;
		int pageNumber = pageIndex + 1;
		PageImage pageImage = null;
		ImageOptions imageOptions = new ImageOptions();
		imageOptions.setConvertImageFileType(_convertImageFileType);
		imageOptions.setTransformations(rotate ? Transformation.Rotate : Transformation.None);

		if (rotate && width != 0) {
			DocumentInfoOptions documentInfoOptions = new DocumentInfoOptions(guid);
			DocumentInfoContainer documentInfoContainer = _imageHandler.getDocumentInfo(documentInfoOptions);

			int side = width;
			int pageAngle = 0;
			int count = 0;
			for (PageData page : documentInfoContainer.getPages()) {
				if (count == pageIndex) {
					pageAngle = page.getAngle();
				}
				count++;

			}
			if (pageAngle == 90 || pageAngle == 270) {
				imageOptions.setHeight(side);
			} else {
				imageOptions.setWidth(side);
			}
		}
		List<PageImage> pageImages = (List<PageImage>) _imageHandler.getPages(guid, imageOptions);

		for (PageImage image : pageImages) {

			if (image.getPageNumber() == pageNumber) {
				pageImage = image;

				lock.unlock();
				return ResponseEntity.ok().contentType(GetContentType(_convertImageFileType))
						.body(new InputStreamResource(pageImage.getStream()));
			}
		}
		lock.unlock();
		return ResponseEntity.ok().contentType(GetContentType(_convertImageFileType))
				.body(new InputStreamResource(pageImage.getStream()));
	}

	@SuppressWarnings("unused")
	private MediaType GetContentType(ConvertImageFileType convertImageFileType) {
		MediaType contentType;
		switch (convertImageFileType) {
		case JPG:
			contentType = MediaType.IMAGE_JPEG;
			break;
		case BMP:
			contentType = MediaType.ALL;
			break;
		case PNG:
			contentType = MediaType.IMAGE_PNG;
			break;
		default:
			throw new IllegalArgumentException();
		}

		return contentType;
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

		queryString.put("useHtmlBasedEngine", String.valueOf(true).toLowerCase());
		myUrl = myUrl + "&useHtmlBasedEngine=" + String.valueOf(true).toLowerCase();
		queryString.put("supportPageRotation", String.valueOf(supportPageRotation).toLowerCase());
		myUrl = myUrl + "&supportPageRotation=" + String.valueOf(supportPageRotation).toLowerCase();
		String handlerName = isPrintable ? "GetPdfWithPrintDialog" : "GetFile";
		String baseUrl = "http://localhost:8080/" + handlerName + "?" + myUrl;
		String fileUrl = baseUrl + handlerName + queryString;
		return baseUrl;
	}

	@RequestMapping(value = "/GetPdfPrintUrl", method = RequestMethod.GET, headers = {
			"Content-type=application/json" })
	@ResponseBody
	private String GetPdfPrintUrl(ViewDocumentParameters request) {
		return GetFileUrl(request.getPath(), true, true, request.getFileDisplayName(), request.getWatermarkText(),
				request.getWatermarkColor(), request.getWatermarkPostion(), request.getWatermarkWidth(),
				request.getIgnoreDocumentAbsence(), request.getUseHtmlBasedEngine(), request.getSupportPageRotation());
	}

}
