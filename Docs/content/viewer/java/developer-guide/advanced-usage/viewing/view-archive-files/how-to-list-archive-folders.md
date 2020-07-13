---
id: how-to-list-archive-folders
url: viewer/java/how-to-list-archive-folders
title: How to list archive folders
weight: 1
description: "This article explains how to get information about an archive with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Listing archive folders

[GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides additional information such as list of folders when calling [getViewInfo(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method. To retrieve view information for Archive File call [getViewInfo(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method and cast output result to [ArchiveViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/ArchiveViewInfo) type.

Following example demonstrates how to print out archive contents.

```java
    public void printViewInfo() {
        Viewer viewer = new Viewer("sample.zip");

        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
        ViewInfo viewInfo = viewer.getViewInfo(viewInfoOptions);

        System.out.println("File type: " + viewInfo.getFileType());
        System.out.println("Pages count: " + viewInfo.getPages().size());
        System.out.println("Folders: ");
        System.out.println(" - /");

        String rootFolder = StringExtensions.Empty;
        printFolders(viewer, rootFolder);
    }


    private void printFolders(Viewer viewer, String folder) {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
        viewInfoOptions.getArchiveOptions().setFolder(folder);

        ArchiveViewInfo viewInfo = (ArchiveViewInfo) viewer.getViewInfo(viewInfoOptions);

        for (String subFolder : viewInfo.getFolders()) {
            System.out.println(" - " + subFolder);
            printFolders(viewer, subFolder);
        }
    }
```

## More resources
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