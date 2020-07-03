---
id: get-view-info-for-archive-file
url: viewer/java/get-view-info-for-archive-file
title: Get View Info for Archive File
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) provides additional information such as a list of folders when calling [getViewInfo](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method. To retrieve view information for Archive File call [getViewInfo](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method and cast output result to [ArchiveViewInfo](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.results/ArchiveViewInfo) type.

The following example demonstrates how to print out archive contents.

```java
public static void readFolders() throws FileNotFoundException {
    Viewer viewer = new Viewer("with_folders.zip");
    ViewInfo info = viewer.getViewInfo(ViewInfoOptions.forHtmlView());

    System.out.println("File type: " + info.getFileType());
    System.out.println("Pages count: " + info.getPages().size());

    System.out.println("Folders: ");
    System.out.println(" - /");

    String rootFolder = "";
    readFolders(viewer, rootFolder);
 
	viewer.close();
}

private static void readFolders(Viewer viewer, String folder) {
    ViewInfoOptions options = ViewInfoOptions.forHtmlView();
    options.getArchiveOptions().setFolder(folder);

    ArchiveViewInfo viewInfo = (ArchiveViewInfo) viewer.getViewInfo(options);

    for (String subFolder : viewInfo.getFolders()) {
        System.out.println(" - " + subFolder);

        readFolders(viewer, subFolder);
    }
}
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