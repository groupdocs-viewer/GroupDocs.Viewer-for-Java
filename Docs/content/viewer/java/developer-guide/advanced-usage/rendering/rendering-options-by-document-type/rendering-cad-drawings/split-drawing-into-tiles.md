---
id: split-drawing-into-tiles
url: viewer/java/split-drawing-into-tiles
title: Split drawing into tiles
weight: 6
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Background

Tiled rendering or (rendering by coordinates) is the process of rendering CAD drawings (into an image, HTML or PDF) by dividing into square parts and rendering each part (or tile) separately. The advantage of this process is that the amount of memory involved is reduced as compared to rendering the entire document at once. Generally, DWG documents are divided into pages by Model and Layouts, but when the tiled rendering is enabled, only the Model is rendered and every tile composes a separate page. 

## Rendering by Coordinates

Before you start rendering by coordinates, you should obtain the overall width and height of the document using the *getViewtInfo()* method of *Viewer* object as shown in the code sample below. After you know the width and height, determine the starting point (X and Y coordinates) and the width and the height of the tile (region you want to render). Add the tiles to *CadOptions.Tiles* list as shown in the sample below. The coordinates start from the bottom left corner of the drawing and have only positive values. 

You can add as many tiles as you need.  
The following code sample demonstrates how to render DWG drawing into an image by dividing it into four equal parts.

```java       
ViewInfoOptions viewInfoOptions = ViewInfoOptions.forPngView(false);
Viewer viewer = new Viewer("with_layers_and_layouts.dwg");
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
PngViewOptions viewOptions = new PngViewOptions("page_{0}.png");
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
```

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)    
*   [GroupDocs.Viewer for Java examples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)    
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-MVC)    
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
    
### Free Online App
Along with full featured Java library we provide simple, but powerful free Apps.  
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online  **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.