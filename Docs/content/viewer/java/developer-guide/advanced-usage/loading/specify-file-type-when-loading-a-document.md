---
id: specify-file-type-when-loading-a-document
url: viewer/java/specify-file-type-when-loading-a-document
title: Specify file type when loading a document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When passing file path or file stream into [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class constructor the GroupDocs.Viewer determines file type by file extension but when file passed as a stream the GroupDocs.Viewer tries to detect file type by file signature or file content and this may affect application performance. The API enables you to specify the file type of the processing document by passing [LoadOptions ](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/LoadOptions) object as the second parameter of [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class constructor. When you're passing file type it instructs GroupDocs.Viewer to skip file type detection feature and proceed with rendering.

The following code sample shows how to pass the file type when loading a document.

```java
        LoadOptions loadOptions = new LoadOptions(FileType.DOCX);    

        Viewer viewer = new Viewer("sample.docx", loadOptions);
        viewer.view(HtmlViewOptions.forEmbeddedResources());     
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
