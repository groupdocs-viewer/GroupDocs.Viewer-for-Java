---
id: net-standard-2-0-api-limitations
url: viewer/java/net-standard-2-0-api-limitations
title: Java API Limitations
weight: 1
description: "This article is about the limitations of GroupDocs.Viewer for Java."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Limitations of Java

This article is about the limitations of GroupDocs.Viewer for Java.

## Limitations

1.  Because of the lack of Windows fonts in target OS (Android, macOS, Linux, etc), fonts used in documents are substituted with available fonts, this might lead to inaccurate document layout when rendering the document to PNG, JPG, and PDF.
2.  If [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) is intended to be used in a Linux environment, an additional package should be referenced to make it work correctly with fonts: [ttf-mscorefonts-installer](https://packages.ubuntu.com/xenial/ttf-mscorefonts-installer) for Ubuntu (it also should work on most Debian-based Linux distributions).

## Recommendations 

When using [GroupDocs.Viewer](https://products.groupdocs.com/viewer) in a non-Windows environment in order to improve rendering results we do recommend installing the following package :

1.  `ttf-mscorefonts-installer` - package with Microsoft compatible fonts.

To install packages on Debian-based Linux distributions use [apt-get](https://wiki.debian.org/apt-get)utility:

1.  `sudo apt-get install msttcorefonts`
2.  `sudo fc-cache -fv`

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer to the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for Java examples, plugins, and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-MVC)     

### Free Online App
Along with full-featured Java library we provide simple but powerful free Apps.
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.