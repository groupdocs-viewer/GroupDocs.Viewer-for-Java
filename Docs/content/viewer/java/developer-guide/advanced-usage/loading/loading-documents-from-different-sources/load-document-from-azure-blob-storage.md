---
id: load-document-from-azure-blob-storage
url: viewer/java/load-document-from-azure-blob-storage
title: Load document from Azure Blob Storage
weight: 2
description: "This article explains how to load a document from Azure Blob Storage with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Following example demonstrates how to render document from Azure Blob Storage.

```java
    String blobName = "sample.docx";

    Viewer viewer = new Viewer(downloadFile(blobName));

    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();

    viewer.view(viewOptions);
    viewer.close();
```

```java
    public InputStream downloadFile(String blobName) {
        CloudBlobContainer container = getContainer();
        CloudBlob blob = container.getBlobReference(blobName);
        ByteArrayOutputStream memoryStream = new ByteArrayOutputStream();
        blob.downloadToStream(memoryStream);
        return new ByteArrayInputStream(memoryStream.toByteArray());
    }

    private CloudBlobContainer getContainer() {
        String accountName = "***";
        String accountKey = "***";
        String endpoint = "https://{accountName}.blob.core.windows.java/";
        String containerName = "***";
        StorageCredentials storageCredentials = new StorageCredentials(accountName, accountKey);
        CloudStorageAccount cloudStorageAccount = new CloudStorageAccount(storageCredentials, new URI(endpoint), null, null, null);
        CloudBlobClient cloudBlobClient = cloudStorageAccount.createCloudBlobClient();
        CloudBlobContainer container = cloudBlobClient.getContainerReference(containerName);
        container.createIfNotExists();
        return container;
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