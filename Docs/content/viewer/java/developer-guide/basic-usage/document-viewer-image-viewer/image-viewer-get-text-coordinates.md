---
id: image-viewer-get-text-coordinates
url: viewer/java/image-viewer-get-text-coordinates
title: Image Viewer - Get text coordinates
weight: 4
description: "Learn how to obtain text coordinates when viewing your documents with Image Viewer by GroupDocs and place text over rendered document page image."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides the feature of getting text coordinates. This feature is useful if you want to add selectable text over the image or implement a text search in image-based rendering. 

The [ExtractText](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewinfooptions/properties/extracttext) property of [ViewInfoOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewinfooptions) classenables you to get the text contained in a source document with coordinates.

Following code sample shows how to retrieve and print out text ([lines](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.results/page/properties/lines) / [words](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.results/line/properties/words) / [characters](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.results/word/properties/characters)) of each document [page](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.results/page) with coordinates.

```java
    Viewer viewer = new Viewer("sample.docx");
    ViewInfoOptions viewInfoOptions = ViewInfoOptions.forPngView(true);
    ViewInfo viewInfo = viewer.getViewInfo(viewInfoOptions);

    for (Page page : viewInfo.getPages()) {
        System.out.println("Page: " + page.getNumber());
        System.out.println("Text lines/words/characters:");

        for (Line line : page.getLines()) {
            System.out.println(line);
            for (Word word : line.getWords()) {
                System.out.println("\t" + word);
                for (Character character : word.getCharacters()) {
                    System.out.println("\t\t" + character);
                }
            }
        }
    }
    viewer.close();
```

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer to the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for Java examples, plugins, and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-MVC)     

### Free Online App
Along with full-featured Java library we provide simple but powerful free Apps.
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.
