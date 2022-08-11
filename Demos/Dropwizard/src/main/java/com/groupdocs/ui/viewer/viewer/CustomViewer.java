package com.groupdocs.ui.viewer.viewer;

import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.viewer.cache.ViewerCache;
import com.groupdocs.ui.viewer.cache.model.*;
import com.groupdocs.ui.viewer.config.ViewerConfiguration;
import com.groupdocs.ui.viewer.util.Utils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.interfaces.FileStreamFactory;
import com.groupdocs.viewer.interfaces.PageStreamFactory;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.Page;
import com.groupdocs.viewer.results.ViewInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public abstract class CustomViewer<T extends ViewOptions> implements Closeable {
    private static final Logger logger = LoggerFactory.getLogger(CustomViewer.class);
    protected static final ReentrantLock syncLock = new ReentrantLock();
    protected static final long LOCK_TIMEOUT = 180_000L;
    private static final Class<?>[] DESERIALIZATION_CLASSES = new Class[]{
            ArchiveViewInfoModel.class,
            AttachmentModel.class,
            CadViewInfoModel.class,
            CharacterModel.class,
            FileInfoModel.class,
            LayerModel.class,
            LayoutModel.class,
            LineModel.class,
            LotusNotesViewInfoModel.class,
            OutlookViewInfoModel.class,
            PageModel.class,
            PdfViewInfoModel.class,
            ProjectManagementViewInfoModel.class,
            ViewInfoModel.class,
            WordModel.class
    };
    protected static ViewerConfiguration viewerConfiguration;
    protected final String filePath;
    protected final ViewerCache cache;
    protected final Viewer viewer;
    protected ViewInfoOptions viewInfoOptions;
    protected T viewOptions;
    protected PdfViewOptions pdfViewOptions;

    public CustomViewer(String filePath, ViewerCache cache, LoadOptions loadOptions) {
        this.cache = cache;
        this.filePath = filePath;
        this.viewer = new Viewer(filePath, loadOptions);
    }

    /**
     * Gets enumeration member by rotation angle value.
     *
     * @param newAngle New rotation angle value.
     * @return Rotation enumeration member.
     */
    protected static Rotation getRotationByAngle(int newAngle) {
        switch (newAngle) {
            case 90:
                return Rotation.ON_90_DEGREE;
            case 180:
                return Rotation.ON_180_DEGREE;
            case 270:
                return Rotation.ON_270_DEGREE;
        }
        return Rotation.ON_90_DEGREE;
    }

    /**
     * Adds watermark on document if its specified in configuration file.
     *
     * @param options View options.
     */
    protected void setWatermarkOptions(ViewOptions options) {
        Watermark watermark = null;

        final String watermarkText = viewerConfiguration.getWatermarkText();
        if (watermarkText != null && !watermarkText.isEmpty()) {
            // Set watermark properties
            watermark = new Watermark(watermarkText);
            watermark.setColor(Color.BLUE);
            watermark.setPosition(Position.DIAGONAL);
        }

        if (watermark != null) {
            options.setWatermark(watermark);
        }
    }

    public ViewInfo getViewInfo() {
        String cacheKey = "view_info.dat";

        return cache.get(cacheKey, () -> getViewer().getViewInfo(viewInfoOptions), DESERIALIZATION_CLASSES);
    }

    public static void setViewerConfiguration(ViewerConfiguration viewerConfiguration) {
        CustomViewer.viewerConfiguration = viewerConfiguration;
    }

    public Viewer getViewer() {
        return this.viewer;
    }

    public void createPdf() {
        String fileKey = "f.pdf";
        try {
            if (this.cache.doesNotContains(fileKey)) {
                final boolean tryLock = syncLock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    logger.trace("createPdf -> syncLock locked");
                    try {
                        if (this.cache.doesNotContains(fileKey)) {
                            this.viewer.view(this.pdfViewOptions);
                        }
                    } finally {
                        syncLock.unlock();
                        logger.trace("createPdf -> syncLock unlocked");
                    }
                } else {
                    logger.error("Request was not handled because lock was not acquired during " + LOCK_TIMEOUT + "ms.");
                    throw new TotalGroupDocsException("Can't handle the request. Server is too busy.");
                }
            }
        } catch (InterruptedException e) {
            logger.warn("Thread that worked with viewer and waited for lock was interrupted", e);
        }
    }

    public void createCache() {
        ViewInfo viewInfo = this.getViewInfo();
        if (viewInfo == null) {
            logger.error("Can't get ViewInfo. The problem can be with deserealization (DESERIALIZATION_CLASSES)");
            throw new TotalGroupDocsException("Can't handle the request. Server is too busy.");
        }

        try {
            int[] missingPages = this.getPagesMissingFromCache(viewInfo.getPages());
            if (missingPages.length > 0) {
                final boolean tryLock = syncLock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    logger.trace("createCache -> syncLock locked");
                    try {
                        missingPages = this.getPagesMissingFromCache(viewInfo.getPages());
                        if (missingPages.length > 0) {
                            this.viewer.view(this.viewOptions, missingPages);
                        }
                    } finally {
                        syncLock.unlock();
                        logger.trace("createCache -> syncLock unlocked");
                    }
                } else {
                    logger.error("Request was not handled because lock was not acquired during " + LOCK_TIMEOUT + "ms.");
                    throw new TotalGroupDocsException("Can't handle the request. Server is too busy.");
                }
            }
        } catch (InterruptedException e) {
            logger.warn("Thread that worked with viewer and waited for lock was interrupted", e);
        }
    }

    protected abstract int[] getPagesMissingFromCache(List<Page> pages);

    protected int[] getPagesMissingFromCache(List<Page> pages, String extension) {
        List<Integer> missingPages = new ArrayList<>();
        for (Page page : pages) {
            String pageKey = "p" + page.getNumber() + extension;
            if (this.cache.doesNotContains(pageKey)) {
                missingPages.add(page.getNumber());
            }
        }

        return ArrayUtils.toPrimitive(missingPages.toArray(new Integer[0]));
    }

    @Override
    public void close() {
        this.viewer.close();
    }
}
