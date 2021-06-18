package com.groupdocs.ui.viewer.viewer;

import com.groupdocs.ui.viewer.cache.ViewerCache;
import com.groupdocs.ui.viewer.config.ViewerConfiguration;
import com.groupdocs.ui.viewer.util.Utils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.interfaces.PageStreamFactory;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.results.*;
import org.apache.commons.lang3.ArrayUtils;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public abstract class CustomViewer<T extends ViewOptions> {
    private static final Class<?>[] DESERIALIZATION_CLASSES = new Class[]{CadViewInfo.class, PdfViewInfo.class, ProjectManagementViewInfo.class, OutlookViewInfo.class, ViewInfo.class};
    protected static ViewerConfiguration viewerConfiguration;
    protected final String filePath;
    protected final ViewerCache cache;
    protected final Viewer viewer;
    protected ViewInfoOptions viewInfoOptions;
    protected T viewOptions;

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

    public void createCache() {
        ViewInfo viewInfo = this.getViewInfo();
        if (viewInfo == null) {
            throw new IllegalStateException("Can't get ViewInfo. The problem can be with deserealization (DESERIALIZATION_CLASSES)");
        }

        synchronized (this.filePath) {
            int[] missingPages = this.getPagesMissingFromCache(viewInfo.getPages());

            if (missingPages.length > 0) {
                this.viewer.view(this.viewOptions, missingPages);
            }
        }
    }

    private int[] getPagesMissingFromCache(java.util.List<Page> pages) {
        List<Integer> missingPages = new ArrayList<>();
        for (Page page : pages) {
            String pageKey = "p" + page.getNumber() + getCachePagesExtension();
            if (this.cache.doesNotContains(pageKey)) {
                missingPages.add(page.getNumber());
            }
        }

        return ArrayUtils.toPrimitive(missingPages.toArray(new Integer[0]));
    }

    protected abstract String getCachePagesExtension();

    public ViewInfo getViewInfo() {
        String cacheKey = "view_info.dat";

        if (cache.doesNotContains(cacheKey)) {
            synchronized (filePath) {
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

    public void close() {
        this.viewer.close();
    }

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
}
