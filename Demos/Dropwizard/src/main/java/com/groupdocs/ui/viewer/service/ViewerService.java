package com.groupdocs.ui.viewer.service;

import com.groupdocs.ui.viewer.config.ViewerConfiguration;
import com.groupdocs.ui.viewer.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.viewer.model.request.LoadDocumentRequest;
import com.groupdocs.ui.viewer.model.request.RotateDocumentPagesRequest;
import com.groupdocs.ui.viewer.model.response.FileDescriptionEntity;
import com.groupdocs.ui.viewer.model.response.LoadDocumentEntity;
import com.groupdocs.ui.viewer.model.response.PageDescriptionEntity;

import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

public interface ViewerService {

    /**
     * Get configuration for viewer module
     *
     * @return viewer configuration
     */
    ViewerConfiguration getViewerConfiguration();

    /**
     * Get list of files in directory
     *
     * @return list of file's descriptions
     */
    List<FileDescriptionEntity> getFileList(String path);

    /**
     * Get document description
     *
     * @param loadDocumentRequest document data for loading
     * @param loadAllPages        to load all pages data of the document
     * @return document info container
     */
    LoadDocumentEntity loadDocument(LoadDocumentRequest loadDocumentRequest, boolean loadAllPages, boolean printVersion);

    /**
     * Get document page
     *
     * @param loadDocumentPageRequest document page request data
     * @return document page info
     */
    PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest);

    /**
     * Rotate document pages
     *
     * @param rotateDocumentPagesRequest rotate pages request info
     * @return list of rotated pages
     */
    PageDescriptionEntity rotateDocumentPages(RotateDocumentPagesRequest rotateDocumentPagesRequest);

    /**
     * Loads resources, as css, js or images
     *
     * @param guid         file guid
     * @param resourceName resource name
     * @return resource data
     */
    Response getResource(String guid, String resourceName);

    /**
     * Retrieves PDF file
     *
     * @param loadDocumentRequest document data for loading
     * @return PDF data
     */
    InputStream getPdf(LoadDocumentRequest loadDocumentRequest);

}
