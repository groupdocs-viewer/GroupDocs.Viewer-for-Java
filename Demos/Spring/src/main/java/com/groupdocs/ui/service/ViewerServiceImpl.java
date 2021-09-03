package com.groupdocs.ui.service;

import com.groupdocs.ui.cache.FileViewerCache;
import com.groupdocs.ui.cache.ViewerCache;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.config.ViewerConfiguration;
import com.groupdocs.ui.exception.DiskAccessException;
import com.groupdocs.ui.exception.ReadWriteException;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.request.RotateDocumentPagesRequest;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import com.groupdocs.ui.model.response.LoadDocumentEntity;
import com.groupdocs.ui.model.response.PageDescriptionEntity;
import com.groupdocs.ui.util.PagesInfoStorage;
import com.groupdocs.ui.util.Utils;
import com.groupdocs.ui.viewer.CustomViewer;
import com.groupdocs.ui.viewer.HtmlViewer;
import com.groupdocs.ui.viewer.PngViewer;
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
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class ViewerServiceImpl implements ViewerService {
    private static final Logger logger = LoggerFactory.getLogger(ViewerServiceImpl.class);

    @Autowired
    private GlobalConfiguration globalConfiguration;
    @Autowired
    private ViewerConfiguration viewerConfiguration;

    private String mCachePath;

    /**
     * Initializing fields after creating configuration objects
     */
    @PostConstruct
    public void init() {
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
                throw new TotalGroupDocsException("Can't list files");
            }

            for (File file : files) {
                // check if current file/folder is hidden
                if (!(file.getName().equals(viewerConfiguration.getCacheFolderName())) && !file.getName().startsWith(".") && !file.isHidden()) {
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
        CustomViewer customViewer = null;
        try {
            String fileCacheSubFolder = createFileCacheSubFolderPath(documentGuid);

            ViewerCache cache = new FileViewerCache(mCachePath, fileCacheSubFolder);

            if (viewerConfiguration.isHtmlMode()) {
                customViewer = new HtmlViewer(documentGuid, cache, createLoadOptions(password));
            } else {
                customViewer = new PngViewer(documentGuid, cache, createLoadOptions(password));
            }
            loadDocumentEntity = getLoadDocumentEntity(loadAllPages, documentGuid, fileCacheSubFolder, customViewer);
            loadDocumentEntity.setShowGridLines(viewerConfiguration.getShowGridLines());
            loadDocumentEntity.setPrintAllowed(viewerConfiguration.getPrintAllowed());
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
        CustomViewer customViewer = null;
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
        CustomViewer customViewer = null;

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
    public ResponseEntity<byte[]> getResource(String guid, String resourceName) {
        try {
            if (!org.apache.commons.lang3.StringUtils.isEmpty(guid)) {
                String path = PathUtils.combine(viewerConfiguration.getFilesDirectory(), viewerConfiguration.getCacheFolderName(), guid, resourceName);
                File resourceFile = new File(path);

                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.setContentType(Utils.detectMediaType(resourceFile.getName()));
                responseHeaders.setContentDisposition(
                        ContentDisposition.builder("inline")
                                .filename(resourceFile.getAbsolutePath())
                                .build()
                );

                return ResponseEntity.ok()
                        .headers(responseHeaders)
                        .body(FileUtils.readFileToByteArray(resourceFile));
            }
        } catch (IOException e) {
            logger.error("Exception in loading resource", e);
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
        return ResponseEntity.badRequest().build();
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
        CustomViewer customViewer = null;
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
        if (password != null && !Strings.isEmpty(password)) {
            loadOptions.setPassword(password);
        }
        return loadOptions;
    }

    private PageDescriptionEntity getPageDescriptionEntity(CustomViewer customViewer, String documentGuid, int pageNumber, String fileCacheSubFolder) throws IOException {
        customViewer.createCache();

        ViewInfo viewInfo = customViewer.getViewInfo();
        Utils.applyWidthHeightFix(customViewer.getViewer(), viewInfo);
        PageDescriptionEntity page = getPageInfo(viewInfo.getPages().get(pageNumber - 1), fileCacheSubFolder);
        page.setData(getPageContent(pageNumber, documentGuid, mCachePath));

        return page;
    }

    private LoadDocumentEntity getLoadDocumentEntity(boolean loadAllPages, String documentGuid, String fileCacheSubFolder, CustomViewer customViewer) {
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

    private InputStream getPdfFile(CustomViewer customViewer, String documentGuid, String fileCacheSubFolder) throws IOException {
        customViewer.createPdf();

        InputStream pdfStream = getPdfFile(documentGuid, mCachePath);

        return pdfStream;
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
