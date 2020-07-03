---
id: load-document-from-ftp
url: viewer/java/load-document-from-ftp
title: Load document from FTP
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
The following example demonstrates how to render a document from FTP.

```java
 		
        String server = "ftp.example.com";
        String filePath = "sample.docx";     

        FTPClient client = new FTPClient();
        client.connect(server);
        InputStream fileStream = client.retrieveFileStream(filePath);

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
       
        Viewer viewer = new Viewer(fileStream);
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
