---
id: load-document-from-ftp
url: viewer/java/load-document-from-ftp
title: Load document from FTP
weight: 3
description: "This article explains how to load a document from FTP storage with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Following example demonstrates how to render a document from FTP.

```java
    public void loadDocumentFromFtp() {
        Viewer viewer = new Viewer(getFileFromFtp("sample.docx"));

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
        viewer.view(viewOptions);
        viewer.close();
    }

    private InputStream getFileFromFtp(String filePath) {
        URI uri = new URI(filePath);
        FtpWebRequest request = createRequest(uri);
        WebResponse response = request.getResponse()
        return getFileStream(response);
    }

    private FtpWebRequest createRequest(URI uri) {
        FtpWebRequest request = (FtpWebRequest) WebRequest.create(uri);
        request.setMethod(WebRequestMethods.Ftp.DOWNLOAD_FILE);
        return request;
    }

    private InputStream getFileStream(WebResponse response) {
        return response.getResponseStream();
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
