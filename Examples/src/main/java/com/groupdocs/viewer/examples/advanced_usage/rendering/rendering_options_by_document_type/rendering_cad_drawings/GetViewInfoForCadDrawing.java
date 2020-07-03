package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.CadViewInfo;
import com.groupdocs.viewer.results.Layer;
import com.groupdocs.viewer.results.Layout;

import java.io.FileNotFoundException;

public class GetViewInfoForCadDrawing {

    /**
     * Get list of all layouts and layers of a CAD drawing
     */

    public static void run() throws FileNotFoundException {
        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
        CadViewInfo info = (CadViewInfo) viewer.getViewInfo(ViewInfoOptions.forHtmlView());
        viewer.close();

        System.out.println("Document type is: " + info.getFileType());
        System.out.println("Pages count: " + info.getPages().size());

        for (Layout layout : info.getLayouts()) {
            System.out.println(layout);
        }

        for (Layer layer : info.getLayers()) {
            System.out.println(layer);
        }

        System.out.println("\nCAD info obtained successfully.");
    }
}