package com.groupdocs.ui.viewer;

import com.groupdocs.ui.cache.ViewerCache;
import com.groupdocs.ui.cache.model.*;
import com.groupdocs.ui.config.ViewerConfiguration;
import com.groupdocs.ui.util.Utils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.interfaces.FileStreamFactory;
import com.groupdocs.viewer.interfaces.PageStreamFactory;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.ViewInfo;

import java.awt.*;
import java.io.*;

public abstract class CustomViewer implements Closeable {
    private static final Object mSync = new Object();
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

        if (cache.doesNotContains(cacheKey)) {
            synchronized (mSync) {
                if (cache.doesNotContains(cacheKey)) {
                    return cache.getValue(cacheKey, this.readViewInfo(viewInfoOptions), DESERIALIZATION_CLASSES);
                }
            }
        }

        return cache.getValue(cacheKey, null, DESERIALIZATION_CLASSES);
    }

    private ViewInfo readViewInfo(ViewInfoOptions viewInfoOptions) {
        ViewInfo viewInfo = getViewer().getViewInfo(viewInfoOptions);
        Utils.applyWidthHeightFix(getViewer(), viewInfo);

        return viewInfo;
    }

    public static void setViewerConfiguration(ViewerConfiguration viewerConfiguration) {
        CustomViewer.viewerConfiguration = viewerConfiguration;
    }

    public Viewer getViewer() {
        return this.viewer;
    }

    public void createPdf() {
        String fileKey = "f.pdf";
        if (this.cache.doesNotContains(fileKey)) {
            synchronized (mSync) {
                if (this.cache.doesNotContains(fileKey)) {
                    this.viewer.view(this.pdfViewOptions);
                }
            }
        }
    }

    @Override
    public void close() {
        this.viewer.close();
    }

    public abstract void createCache();


    protected class CustomPageStreamFactory implements PageStreamFactory {
        private final String mExtension;

        public CustomPageStreamFactory(String extension) {
            this.mExtension = extension;
        }

        @Override
        public OutputStream createPageStream(int pageNumber) {
            String fileName = "p" + pageNumber + mExtension;
            String cacheFilePath = cache.getCacheFilePath(fileName);

            try {
                return new FileOutputStream(cacheFilePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        @Override
        public void closePageStream(int pageNumber, OutputStream outputStream) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    protected class CustomFileStreamFactory implements FileStreamFactory {
        private final String mExtension;

        public CustomFileStreamFactory(String extension) {
            this.mExtension = extension;
        }

        @Override
        public OutputStream createFileStream() {
            String fileName = "f" + mExtension;
            String cacheFilePath = cache.getCacheFilePath(fileName);

            try {
                return new FileOutputStream(cacheFilePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        @Override
        public void closeFileStream(OutputStream outputStream) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
