package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PngViewOptions;
import com.groupdocs.viewer.options.Tile;
import com.groupdocs.viewer.options.ViewInfoOptions;
import com.groupdocs.viewer.results.ViewInfo;

import java.io.File;
import java.io.IOException;

public class SplitDrawingIntoTiles {

    /**
     * This example demonstrates how to split drawing into tiles.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("SplitDrawingIntoTiles");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.png").getPath();

        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forPngView(false);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
        ViewInfo viewInfo = viewer.getViewInfo(viewInfoOptions);

        // Get width and height
        int width = viewInfo.getPages().get(0).getWidth();
        int height = viewInfo.getPages().get(0).getHeight();

        // Set tile width and height as a half of image total width
        int tileWidth = width / 2;
        int tileHeight = height / 2;

        int pointX = 0;
        int pointY = 0;

        // Create image options and add four tiles, one for each quarter
        PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);

        Tile tile = new Tile(pointX, pointY, tileWidth, tileHeight);
        viewOptions.getCadOptions().getTiles().add(tile);

        pointX += tileWidth;
        tile = new Tile(pointX, pointY, tileWidth, tileHeight);
        viewOptions.getCadOptions().getTiles().add(tile);

        pointX = 0;
        pointY += tileHeight;
        tile = new Tile(pointX, pointY, tileWidth, tileHeight);
        viewOptions.getCadOptions().getTiles().add(tile);

        pointX += tileWidth;
        tile = new Tile(pointX, pointY, tileWidth, tileHeight);
        viewOptions.getCadOptions().getTiles().add(tile);

        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}