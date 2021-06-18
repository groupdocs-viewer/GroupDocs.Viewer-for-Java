package com.groupdocs.ui.viewer.resources;

import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.resources.Resources;
import com.groupdocs.ui.viewer.config.ViewerConfiguration;
import com.groupdocs.ui.viewer.model.request.FileTreeRequest;
import com.groupdocs.ui.viewer.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.viewer.model.request.LoadDocumentRequest;
import com.groupdocs.ui.viewer.model.request.RotateDocumentPagesRequest;
import com.groupdocs.ui.viewer.model.response.FileDescriptionEntity;
import com.groupdocs.ui.viewer.model.response.LoadDocumentEntity;
import com.groupdocs.ui.viewer.model.response.PageDescriptionEntity;
import com.groupdocs.ui.viewer.model.response.UploadedDocumentEntity;
import com.groupdocs.ui.viewer.service.ViewerService;
import com.groupdocs.ui.viewer.service.ViewerServiceImpl;
import com.groupdocs.ui.viewer.views.Viewer;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.*;

/**
 * Viewer Resources
 *
 * @author Aspose Pty Ltd
 */

@Path(value = "/viewer")
public class ViewerResources extends Resources {

    private final ViewerService viewerService;

    /**
     * Constructor
     *
     * @param globalConfiguration global configuration object
     * @throws UnknownHostException
     */
    public ViewerResources(GlobalConfiguration globalConfiguration) throws UnknownHostException {
        super(globalConfiguration);

        viewerService = new ViewerServiceImpl(globalConfiguration);
    }

    /**
     * Get and set viewer page
     *
     * @return html view
     */
    @GET
    public Viewer getView() {
        // initiate index page
        return new Viewer(globalConfiguration, DEFAULT_CHARSET);
    }

    @GET
    @Path(value = "/loadConfig")
    @Produces(APPLICATION_JSON)
    public ViewerConfiguration loadConfig() {
        return ViewerConfiguration.createViewerConfiguration(globalConfiguration.getViewer(), globalConfiguration.getCommon());
    }

    /**
     * Get files and directories
     *
     * @param fileTreeRequest request's object with specified path
     * @return files and directories list
     */
    @POST
    @Path(value = "/loadFileTree")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<FileDescriptionEntity> loadFileTree(FileTreeRequest fileTreeRequest) {
        return viewerService.getFileList(fileTreeRequest.getPath());
    }

    /**
     * Get document description
     *
     * @param loadDocumentRequest request's object with parameters
     * @return document description
     */
    @POST
    @Path(value = "/loadDocumentDescription")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public LoadDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        if (StringUtils.isEmpty(loadDocumentRequest.getGuid())) {
            throw new TotalGroupDocsException("Document guid is empty!");
        }
        return viewerService.loadDocument(loadDocumentRequest, globalConfiguration.getViewer().getPreloadPageCount() == 0);
    }

    /**
     * Get all pages for thumbnails
     *
     * @param loadDocumentRequest
     * @return
     */
    @POST
    @Path(value = "/loadThumbnails")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public LoadDocumentEntity loadThumbnails(LoadDocumentRequest loadDocumentRequest) {
        return viewerService.loadDocument(loadDocumentRequest, true);
    }

    /**
     * Get document page
     *
     * @param loadDocumentPageRequest request's object with parameters
     * @return document page
     */
    @POST
    @Path(value = "/loadDocumentPage")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        return viewerService.loadDocumentPage(loadDocumentPageRequest);
    }

    /**
     * Get document for printing
     *
     * @param loadDocumentRequest
     * @return
     */
    @POST
    @Path(value = "/loadPrint")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public LoadDocumentEntity loadPrint(LoadDocumentRequest loadDocumentRequest) {
        return viewerService.loadDocument(loadDocumentRequest, true);
    }

    /**
     * Get pdf document for printing
     *
     * @return
     */
    @POST
    @Path(value = "/printPdf")
    @Consumes(APPLICATION_JSON)
    public void printPdf(LoadDocumentRequest loadDocumentRequest, @Context HttpServletResponse response) {
        downloadFile(response, loadDocumentRequest.getGuid());
    }

    /**
     * Rotate page(s)
     *
     * @param rotateDocumentPagesRequest request's object with parameters
     * @return rotated pages list (each object contains page number and rotated angle information)
     */
    @POST
    @Path(value = "/rotateDocumentPages")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public PageDescriptionEntity rotateDocumentPages(RotateDocumentPagesRequest rotateDocumentPagesRequest) {
        return viewerService.rotateDocumentPages(rotateDocumentPagesRequest);
    }

    /**
     * Download document
     *
     * @param documentGuid path to document parameter
     * @param response
     */
    @GET
    @Path(value = "/downloadDocument")
    @Produces(APPLICATION_OCTET_STREAM)
    public void downloadDocument(@QueryParam("path") String documentGuid, @Context HttpServletResponse response) {
        downloadFile(response, documentGuid);
    }

    @GET
    @Path(value = "resources/{guid}/{resourceName}")
    @Produces(APPLICATION_OCTET_STREAM)
    public Response downloadDocument(@PathParam("guid") String guid, @PathParam("resourceName") String resourceName) {
        return viewerService.getResource(guid, resourceName);
    }

    /**
     * Upload document
     *
     * @param inputStream file content
     * @param fileDetail  file description
     * @param documentUrl url for document
     * @param rewrite     flag for rewriting file
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @POST
    @Path(value = "/uploadDocument")
    @Produces(APPLICATION_JSON)
    @Consumes(MULTIPART_FORM_DATA)
    public UploadedDocumentEntity uploadDocument(@FormDataParam("file") InputStream inputStream,
                                                 @FormDataParam("file") FormDataContentDisposition fileDetail,
                                                 @FormDataParam("url") String documentUrl,
                                                 @FormDataParam("rewrite") Boolean rewrite) {
        // upload file
        String pathname = uploadFile(documentUrl, inputStream, fileDetail, rewrite, null);
        // create response
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathname);
        return uploadedDocument;
    }

    @Override
    protected String getStoragePath(Map<String, Object> params) {
        return globalConfiguration.getViewer().getFilesDirectory();
    }
}
