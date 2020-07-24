---
id: load-document-from-amazon-s3-storage
url: viewer/java/load-document-from-amazon-s3-storage
title: Load document from Amazon S3 Storage
weight: 1
description: "This article explains how to load a document from Amazon S3 Storage with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Following example demonstrates how to render document from Amazon S3 Storage.

```java
    String key = "sample.docx";

    Viewer viewer = new Viewer(downloadFile(key));
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();

    viewer.view(viewOptions);
    viewer.close();
```

```java
    public InputStream downloadFile(String key) {
        AmazonS3Client client = new AmazonS3Client();
        String bucketName = "my-bucket";
        GetObjectRequest request = new GetObjectRequest();
        request.setKey(key);
        request.setBucketName(bucketName);
        GetObjectResponse response = client.getObject(request);
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
