---
id: load-document-from-url
url: viewer/java/load-document-from-url
title: Load document from URL
weight: 6
description: "This article explains how to load a document from URL with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Following example demonstrates how to render document from URL.

```java
    public void loadDocumentFromUrl() {
        String url = "https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/blob/master/Examples/Resources/SampleFiles/sample.docx?raw=true";

        Viewer viewer = new Viewer(getRemoteFile(url));

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
        viewer.view(viewOptions);
        viewer.close();
    }

    private InputStream getRemoteFile(String url) {
        WebRequest request = WebRequest.create(url);
        WebResponse response = request.getResponse();
        return getFileStream(response);
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