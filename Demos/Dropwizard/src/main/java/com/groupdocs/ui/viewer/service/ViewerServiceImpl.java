package com.groupdocs.ui.viewer.service;

import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.viewer.cache.FileViewerCache;
import com.groupdocs.ui.viewer.cache.ViewerCache;
import com.groupdocs.ui.viewer.config.ViewerConfiguration;
import com.groupdocs.ui.viewer.exception.DiskAccessException;
import com.groupdocs.ui.viewer.exception.ReadWriteException;
import com.groupdocs.ui.viewer.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.viewer.model.request.LoadDocumentRequest;
import com.groupdocs.ui.viewer.model.request.RotateDocumentPagesRequest;
import com.groupdocs.ui.viewer.model.response.FileDescriptionEntity;
import com.groupdocs.ui.viewer.model.response.LoadDocumentEntity;
import com.groupdocs.ui.viewer.model.response.PageDescriptionEntity;
import com.groupdocs.ui.viewer.util.PagesInfoStorage;
import com.groupdocs.ui.viewer.util.Utils;
import com.groupdocs.ui.viewer.viewer.CustomViewer;
import com.groupdocs.ui.viewer.viewer.HtmlViewer;
import com.groupdocs.ui.viewer.viewer.PngViewer;
import com.groupdocs.viewer.License;
import com.groupdocs.viewer.exception.IncorrectPasswordException;
import com.groupdocs.viewer.exception.PasswordRequiredException;
import com.groupdocs.viewer.fonts.FolderFontSource;
import com.groupdocs.viewer.fonts.FontSettings;
import com.groupdocs.viewer.fonts.FontSource;
import com.groupdocs.viewer.fonts.SearchOption;
import com.groupdocs.viewer.options.LoadOptions;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ViewInfo;
import com.groupdocs.viewer.utils.PathUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ViewerServiceImpl implements ViewerService {
    private static final Logger logger = LoggerFactory.getLogger(ViewerServiceImpl.class);

    private final ViewerConfiguration viewerConfiguration;
    private final GlobalConfiguration globalConfiguration;

    private final String mCachePath;


    public ViewerServiceImpl(GlobalConfiguration globalConfiguration) {
        this.viewerConfiguration = globalConfiguration.getViewer();
        this.globalConfiguration = globalConfiguration;

        setLicense();

        // Register custom fonts
        if (!StringUtils.isEmpty(viewerConfiguration.getFontsDirectory())) {
            FontSource fontSource = new FolderFontSource(viewerConfiguration.getFontsDirectory(), SearchOption.TOP_FOLDER_ONLY);
            FontSettings.setFontSources(fontSource);
        }
        //
        mCachePath = PathUtils.combine(viewerConfiguration.getFilesDirectory(), viewerConfiguration.getCacheFolderName());

        HtmlViewer.setViewerConfiguration(viewerConfiguration);
        PngViewer.setViewerConfiguration(viewerConfiguration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FileDescriptionEntity> getFileList(String path) {
        final File filesDirectory = new File(PathUtils.combine(viewerConfiguration.getFilesDirectory(), path));

        List<FileDescriptionEntity> filesList = new ArrayList<>();
        try {
            final File[] files = filesDirectory.listFiles();
            if (files == null) {
                throw new TotalGroupDocsException("Can't list files of '" + filesDirectory.getAbsolutePath() + "' folder");
            }

            for (File file : files) {
                // check if current file/folder is hidden
                if (!file.getName().equals(viewerConfiguration.getCacheFolderName()) && !file.getName().startsWith(".") && !file.isHidden()) {
                    FileDescriptionEntity fileDescription = new FileDescriptionEntity();
                    fileDescription.setGuid(file.getCanonicalFile().getAbsolutePath());
                    fileDescription.setName(file.getName());
                    // set is directory true/false
                    fileDescription.setIsDirectory(file.isDirectory());

                    // set file size
                    if (!fileDescription.isIsDirectory()) {
                        fileDescription.setSize(file.length());
                    }

                    // add object to array list
                    filesList.add(fileDescription);
                }
            }

            // Sort by name and to make directories to be before files
            Collections.sort(filesList, new Comparator<FileDescriptionEntity>() {
                @Override
                public int compare(FileDescriptionEntity o1, FileDescriptionEntity o2) {
                    if (o1.isIsDirectory() && !o2.isIsDirectory()) {
                        return -1;
                    }
                    if (!o1.isIsDirectory() && o2.isIsDirectory()) {
                        return 1;
                    }
                    return o1.getName().compareTo(o2.getName());
                }
            });
        } catch (IOException e) {
            logger.error("Exception in getting file list", e);
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
        return filesList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoadDocumentEntity loadDocument(LoadDocumentRequest loadDocumentRequest, boolean loadAllPages) {
        // set request parameters
        String documentGuid = loadDocumentRequest.getGuid();
        String password = loadDocumentRequest.getPassword();
        password = org.apache.commons.lang3.StringUtils.isEmpty(password) ? null : password;
        LoadDocumentEntity loadDocumentEntity;
        CustomViewer<?> customViewer = null;
        try {
            String fileCacheSubFolder = createFileCacheSubFolderPath(documentGuid);

            ViewerCache cache = new FileViewerCache(mCachePath, fileCacheSubFolder);

            if (viewerConfiguration.isHtmlMode()) {
                customViewer = new HtmlViewer(documentGuid, cache, createLoadOptions(password));
            } else {
                customViewer = new PngViewer(documentGuid, cache, createLoadOptions(password));
            }
            loadDocumentEntity = getLoadDocumentEntity(loadAllPages, documentGuid, fileCacheSubFolder, customViewer);
            loadDocumentEntity.setShowGridLines(viewerConfiguration.isShowGridLines());
            loadDocumentEntity.setPrintAllowed(viewerConfiguration.isPrintAllowed());
        } catch (IncorrectPasswordException | PasswordRequiredException ex) {
            logger.error("Exception that is connected to password", ex);
            throw new TotalGroupDocsException(Utils.getExceptionMessage(password), ex);
        } catch (Exception ex) {
            logger.error("Exception in loading document", ex);
            throw new TotalGroupDocsException("Exception in loading document", ex);
        } finally {
            if (customViewer != null) {
                customViewer.close();
            }
        }
        return loadDocumentEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        String documentGuid = loadDocumentPageRequest.getGuid();
        Integer pageNumber = loadDocumentPageRequest.getPage();
        String password = loadDocumentPageRequest.getPassword();
        password = org.apache.commons.lang3.StringUtils.isEmpty(password) ? null : password;
        CustomViewer<?> customViewer = null;
        try {
            String fileCacheSubFolder = createFileCacheSubFolderPath(documentGuid);

            ViewerCache cache = new FileViewerCache(mCachePath, fileCacheSubFolder);

            if (viewerConfiguration.isHtmlMode()) {
                customViewer = new HtmlViewer(documentGuid, cache, createLoadOptions(password));
            } else {
                customViewer = new PngViewer(documentGuid, cache, createLoadOptions(password));
            }
            return getPageDescriptionEntity(customViewer, documentGuid, pageNumber, fileCacheSubFolder);
        } catch (Exception ex) {
            logger.error("Exception in loading document page", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        } finally {
            if (customViewer != null) {
                customViewer.close();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageDescriptionEntity rotateDocumentPages(RotateDocumentPagesRequest rotateDocumentPagesRequest) {
        // set request parameters
        String documentGuid = rotateDocumentPagesRequest.getGuid();
        List<Integer> pages = rotateDocumentPagesRequest.getPages();
        String password = rotateDocumentPagesRequest.getPassword();
        Integer angle = rotateDocumentPagesRequest.getAngle();
        int pageNumber = pages.get(0);
        CustomViewer<?> customViewer = null;

        try {
            String fileCacheSubFolder = createFileCacheSubFolderPath(documentGuid);

            // Delete cache files connected to the page
            for (File file : new File(fileCacheSubFolder).listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith("p" + pageNumber);
                }
            })) {
                if (!file.delete()) {
                    file.deleteOnExit();
                    logger.error("Exception in deleting cache path");
                    throw new DiskAccessException("delete cache file", file);
                }
            }
            // Getting new rotation angle value.
            int currentAngle = PagesInfoStorage.loadPageAngle(fileCacheSubFolder, pageNumber);
            int newAngle = mergeAngles(currentAngle, angle);
            PagesInfoStorage.savePageAngle(fileCacheSubFolder, pageNumber, newAngle);
            // Generate new cache
            ViewerCache cache = new FileViewerCache(mCachePath, fileCacheSubFolder);
            if (viewerConfiguration.isHtmlMode()) {
                customViewer = new HtmlViewer(documentGuid, cache, createLoadOptions(password), pageNumber, newAngle);
            } else {
                customViewer = new PngViewer(documentGuid, cache, createLoadOptions(password), pageNumber, newAngle);
            }
            return getPageDescriptionEntity(customViewer, documentGuid, pageNumber, fileCacheSubFolder);

        } catch (Exception ex) {
            logger.error("Exception in rotating document page", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        } finally {
            if (customViewer != null) {
                customViewer.close();
            }
        }
    }

    @Override
    public Response getResource(String guid, String resourceName) {
        try {
            if (!org.apache.commons.lang3.StringUtils.isEmpty(guid)) {
                String path = PathUtils.combine(viewerConfiguration.getFilesDirectory(), viewerConfiguration.getCacheFolderName(), guid, resourceName);
                File resourceFile = new File(path);

                return Response.ok(FileUtils.readFileToByteArray(resourceFile))
                        .type(Utils.detectMediaType(resourceFile.getName()))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resourceFile.getName() + "\"")
                        .build();

            }
        } catch (IOException e) {
            logger.error("Exception in loading resource", e);
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
        return Response.serverError().build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewerConfiguration getViewerConfiguration() {
        return viewerConfiguration;
    }

    @Override
    public InputStream getPdf(LoadDocumentRequest loadDocumentRequest) {
        String documentGuid = loadDocumentRequest.getGuid();
        String password = loadDocumentRequest.getPassword();
        password = org.apache.commons.lang3.StringUtils.isEmpty(password) ? null : password;
        CustomViewer<?> customViewer = null;
        try {
            String fileCacheSubFolder = createFileCacheSubFolderPath(documentGuid);
            ViewerCache cache = new FileViewerCache(mCachePath, fileCacheSubFolder);

            if (viewerConfiguration.isHtmlMode()) {
                customViewer = new HtmlViewer(documentGuid, cache, createLoadOptions(password));
            } else {
                customViewer = new PngViewer(documentGuid, cache, createLoadOptions(password));
            }
            return getPdfFile(customViewer, documentGuid, fileCacheSubFolder);
        } catch (Exception ex) {
            logger.error("Exception in loading document page", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        } finally {
            if (customViewer != null) {
                customViewer.close();
            }
        }
    }

    private String createFileCacheSubFolderPath(String documentGuid) {
        String fileFolderName = new File(documentGuid).getName().replace(".", "_");
        return PathUtils.combine(mCachePath, fileFolderName);
    }

    private static LoadOptions createLoadOptions(String password) {
        final LoadOptions loadOptions = new LoadOptions();
        if (password != null && !password.isEmpty()) {
            loadOptions.setPassword(password);
        }
        return loadOptions;
    }

    private PageDescriptionEntity getPageDescriptionEntity(CustomViewer<?> customViewer, String documentGuid, int pageNumber, String fileCacheSubFolder) throws IOException {
        customViewer.createCache();

        ViewInfo viewInfo = customViewer.getViewInfo();
        Utils.applyWidthHeightFix(customViewer.getViewer(), viewInfo);
        PageDescriptionEntity page = getPageInfo(viewInfo.getPages().get(pageNumber - 1), fileCacheSubFolder);
        page.setData(getPageContent(pageNumber, documentGuid, mCachePath));

        return page;
    }

    private InputStream getPdfFile(CustomViewer<?> customViewer, String documentGuid, String fileCacheSubFolder) throws IOException {
        customViewer.createPdf();

        InputStream pdfStream = getPdfFile(documentGuid, mCachePath);

        return pdfStream;
    }

    private LoadDocumentEntity getLoadDocumentEntity(boolean loadAllPages, String documentGuid, String fileCacheSubFolder, CustomViewer<?> customViewer) {
        try {
            if (loadAllPages) {
                customViewer.createCache();
            }

            ViewInfo viewInfo = customViewer.getViewInfo();
            LoadDocumentEntity loadDocumentEntity = new LoadDocumentEntity();

            final File file = new File(mCachePath);
            if (!file.exists() && !file.mkdir()) {
                throw new DiskAccessException("create cache directory", file);
            }

            String pagesInfoPath = PagesInfoStorage.createPagesInfo(fileCacheSubFolder, viewInfo);

            for (Page page : viewInfo.getPages()) {
                PageDescriptionEntity pageData = getPageInfo(page, pagesInfoPath);
                if (loadAllPages) {
                    pageData.setData(getPageContent(page.getNumber(), documentGuid, mCachePath));
                }

                loadDocumentEntity.getPages().add(pageData);
            }

            loadDocumentEntity.setGuid(documentGuid);
            return loadDocumentEntity;
        } catch (Exception e) {
            throw new ReadWriteException(e);
        }
    }

    private String getPageContent(int pageNumber, String documentGuid, String cachePath) throws IOException {
        String fileFolderName = new File(documentGuid).getName().replace(".", "_");

        if (viewerConfiguration.isHtmlMode()) {
            String htmlFilePath = cachePath + "/" + fileFolderName + "/p" + pageNumber + ".html";
            return FileUtils.readFileToString(new File(htmlFilePath));
        } else {
            String pngFilePath = cachePath + "/" + fileFolderName + "/p" + pageNumber + ".png";

            byte[] imageBytes = FileUtils.readFileToByteArray(new File(pngFilePath));

            return Base64.getEncoder().encodeToString(imageBytes);
        }
    }

    private InputStream getPdfFile(String documentGuid, String cachePath) throws IOException {
        String fileFolderName = new File(documentGuid).getName().replace(".", "_");
        String pngFilePath = cachePath + "/" + fileFolderName + "/f.pdf";

        byte[] fileBytes = FileUtils.readFileToByteArray(new File(pngFilePath));

        return new ByteArrayInputStream(fileBytes);
    }

    private static int mergeAngles(int currentAngle, int angle) {
        switch (currentAngle) {
            case 0:
                return (angle == 90 ? 90 : 270);
            case 90:
                return (angle == 90 ? 180 : 0);
            case 180:
                return (angle == 90 ? 270 : 90);
            case 270:
                return (angle == 90 ? 0 : 180);
        }
        return 0;
    }

    private void setLicense() {
        try {
            // set GroupDocs license
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable throwable) {
            logger.error("Can not verify Viewer license!");
        }
    }

    private static PageDescriptionEntity getPageInfo(Page page, String pagesInfoPath) {

        int currentAngle = PagesInfoStorage.loadPageAngle(pagesInfoPath, page.getNumber());

        PageDescriptionEntity pageDescriptionEntity = new PageDescriptionEntity();

        pageDescriptionEntity.setNumber(page.getNumber());

        // we intentionally use the 0 here because we plan to rotate only the page background using height/width
        pageDescriptionEntity.setAngle(0);
        pageDescriptionEntity.setHeight(currentAngle == 0 || currentAngle == 180 ? page.getHeight() : page.getWidth());
        pageDescriptionEntity.setWidth(currentAngle == 0 || currentAngle == 180 ? page.getWidth() : page.getHeight());

        return pageDescriptionEntity;
    }
    
}
