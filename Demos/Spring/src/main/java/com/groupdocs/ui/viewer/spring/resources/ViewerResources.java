package com.groupdocs.ui.viewer.spring.resources;

import com.groupdocs.ui.viewer.spring.common.config.GlobalConfiguration;
import com.groupdocs.ui.viewer.spring.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.viewer.spring.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.viewer.spring.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.viewer.spring.common.entity.web.UploadedDocumentEntity;
import com.groupdocs.ui.viewer.spring.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.viewer.spring.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.viewer.spring.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.viewer.spring.common.entity.web.request.RotateDocumentPagesRequest;
import com.groupdocs.ui.viewer.spring.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.viewer.spring.common.resources.Resources;
import com.groupdocs.ui.viewer.spring.common.util.Utils;
import com.groupdocs.ui.viewer.spring.config.ViewerConfiguration;
import com.groupdocs.ui.viewer.spring.service.ViewerService;
import com.groupdocs.viewer.utils.PathUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

import static com.groupdocs.ui.viewer.spring.common.util.Utils.setLocalPort;
import static com.groupdocs.ui.viewer.spring.common.util.Utils.uploadFile;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
@Scope("session")
@RequestMapping(value = "/viewer")
public class ViewerResources extends Resources {

    private static final Logger logger = LoggerFactory.getLogger(ViewerResources.class);

    @Autowired
    private GlobalConfiguration globalConfiguration;

    @Autowired
    private ViewerService viewerService;

    /**
     * Get viewer page
     *
     * @param request http request
     * @param model   model data for template
     * @return template name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getView(HttpServletRequest request, Map<String, Object> model) {
        setLocalPort(request, globalConfiguration.getServer());

        model.put("globalConfiguration", globalConfiguration);

        logger.debug("viewer config: {}", viewerService.getViewerConfiguration());
        model.put("viewerConfiguration", viewerService.getViewerConfiguration());
        return "viewer";
    }

    /**
     * Get files and directories
     *
     * @return files and directories list
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadFileTree",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FileDescriptionEntity> loadFileTree(@RequestBody FileTreeRequest fileTreeRequest) {
        return viewerService.getFileList(fileTreeRequest.getPath());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loadConfig", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ViewerConfiguration loadConfig() {
        return viewerService.getViewerConfiguration();
    }

    /**
     * Get document description
     *
     * @return document description
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadDocumentDescription", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public LoadDocumentEntity loadDocumentDescription(@RequestBody LoadDocumentRequest loadDocumentRequest) {
        return viewerService.loadDocument(loadDocumentRequest, viewerService.getViewerConfiguration().getPreloadPageCount() == 0, false);
    }

    /**
     * Get all pages for thumbnails
     *
     * @param loadDocumentRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadThumbnails", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public LoadDocumentEntity loadThumbnails(@RequestBody LoadDocumentRequest loadDocumentRequest) {
        return viewerService.loadDocument(loadDocumentRequest, true, false);
    }

    /**
     * Get document for printing
     *
     * @param loadDocumentRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadPrint", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public LoadDocumentEntity loadPrint(@RequestBody LoadDocumentRequest loadDocumentRequest) {
        return viewerService.loadDocument(loadDocumentRequest, true, true);
    }

    /**
     * Get pdf document for printing
     */
    @RequestMapping(method = RequestMethod.POST, value = "/printPdf", consumes = APPLICATION_JSON_VALUE)
    public void printPdf(@RequestBody LoadDocumentRequest loadDocumentRequest, HttpServletResponse response) {
        String fileName = FilenameUtils.getName(loadDocumentRequest.getGuid());
        String fileExtension = FilenameUtils.getExtension(fileName);
        String pdfFileName = fileName.replace(fileExtension, "pdf");
        InputStream inputStream = viewerService.getPdf(loadDocumentRequest);

        try (OutputStream outputStream = response.getOutputStream()) {
            int size = inputStream.available();

            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            response.setHeader("Content-Type", "application/pdf");
            response.setHeader("Content-Length", String.valueOf(size));

            IOUtils.copyLarge(inputStream, outputStream);
        } catch (Exception ex) {
            logger.error("Exception in opening document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Get document page
     *
     * @return document page info
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadDocumentPage", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageDescriptionEntity loadDocumentPage(@RequestBody LoadDocumentPageRequest loadDocumentPageRequest) {
        return viewerService.loadDocumentPage(loadDocumentPageRequest);
    }

    /**
     * Rotate page(s)
     *
     * @return rotated pages list (each object contains page number and rotated angle information)
     */
    @RequestMapping(method = RequestMethod.POST, value = "/rotateDocumentPages", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageDescriptionEntity rotateDocumentPages(@RequestBody RotateDocumentPagesRequest rotateDocumentPagesRequest) {
        return viewerService.rotateDocumentPages(rotateDocumentPagesRequest);
    }

    /**
     * Download document
     */
    @RequestMapping(method = RequestMethod.GET, value = "/downloadDocument")
    public void downloadDocument(@RequestParam(name = "path") String documentGuid, HttpServletResponse response) {
        String documentPath = PathUtils.combine(viewerService.getViewerConfiguration().getFilesDirectory(), Utils.normalizeGuidToPath(documentGuid));
        File file = new File(documentPath);
        // set response content info
        addFileDownloadHeaders(response, file.getName(), file.length());
        // download the document
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(documentPath));
             ServletOutputStream outputStream = response.getOutputStream()) {

            IOUtils.copyLarge(inputStream, outputStream);
        } catch (Exception ex) {
            logger.error("Exception in downloading document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Upload document
     *
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadDocument",
            consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public UploadedDocumentEntity uploadDocument(@Nullable @RequestParam("file") MultipartFile content,
                                                 @RequestParam(value = "url", required = false) String url,
                                                 @RequestParam("rewrite") Boolean rewrite) {
        // get documents storage path
        String documentStoragePath = viewerService.getViewerConfiguration().getFilesDirectory();
        // upload the file
        String pathToFile = uploadFile(documentStoragePath, content, url, rewrite);
        // create response data
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathToFile);
        return uploadedDocument;
    }

    /**
     * Rotate page(s)
     *
     * @return rotated pages list (each object contains page number and rotated angle information)
     */
    @RequestMapping(method = RequestMethod.GET, value = "resources/{guid}/{resourceName}")
    @ResponseBody
    public ResponseEntity<byte[]> getResource(@PathVariable String guid, @PathVariable String resourceName) {
        return viewerService.getResource(guid, resourceName);
    }

}
