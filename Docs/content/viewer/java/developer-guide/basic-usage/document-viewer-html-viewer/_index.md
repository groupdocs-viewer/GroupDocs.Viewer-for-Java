---
id: document-viewer-html-viewer
url: viewer/java/document-viewer-html-viewer
title: Document viewer - HTML Viewer
weight: 1
description: "HTML Viewer component by GroupDocs allows to render and display documents of PDF, Word, Excel, PowerPoint and many other file formats within Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Document viewer can operate in different rendering modes, HTML, Image and PDF (see [Features Overview]({{< ref "viewer/java/developer-guide/basic-usage/document-viewer-html-viewer/_index.md" >}}) for more information). This article will describe on how to view documents in HTML mode with HTML Viewer.

In HTML rendering mode all pages of the source documents are rendered as separate HTML pages. 

For HTML rendering mode following [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) are available:

*   [HtmlViewOptions.forEmbeddedResources](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions#forEmbeddedResources()) - all resources such as styles, fonts, and graphics are integrated into an HTML pages.    
    *   Pros: No external files which makes more convenient to save result to a stream.        
    *   Cons: Larger page size and as a result slower loading and rendering of an HTML document in a browser.        
*   [HtmlViewOptions.forExternalResources](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions#forExternalResources()) - all the resources, such as styles, fonts, and graphics are external.    
    *   Pros: Smaller page size as a page includes only markup and links to external resources. Faster HTML document loading and rendering in a browser as browsers can load multiple external resources simultaneously.        
    *   Cons: External files, since all resources will be stored next to an HTML page or in a specific directory.

With GroupDocs.Viewer for Java API HTML rendering became simple and intuitive. Just follow these steps:
*   Create a new instance of the [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class and pass the source document path as a constructor parameter.    
*   Instantiate the [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) object according to your requirements (for embedded or external HTML resources) and specify saving path format for rendered document pages.    
*   Call [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method of [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class instance and pass [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) to it.
    

## Document viewer - HTML Viewer (embedded resources)

The following code shows how to render document to HTML with embedded resources.  

```java
// The file path format e.g. 'page_{0}.html'
String filePathFormat = "page-{0}.html";
HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(filePathFormat);
 
Viewer viewer = new Viewer("sample.docx");
viewer.view(options);
viewer.close();
```


## Document viewer - HTML Viewer (external resources)

The following code shows how to render document to HTML with external resources.  

```java
	// The file path format e.g. 'page_{0}.html'
	String filePathFormat = "page-{0}.html";
	// The resource file path format e.g. 'page_{0}_{1}'
	String resourceFilePathFormat = "page_{0}_{1}"; 
	// The resource URL format e.g. 'page_{0}_{1}' or "http://contoso.com/page_{0}/resource_{1}"
	String resourceUrlFormat = "page_{0}_{1}";

	HtmlViewOptions options = HtmlViewOptions.forExternalResources(filePathFormat, resourceFilePathFormat, resourceUrlFormat);
 
	Viewer viewer = new Viewer("sample.docx");
	viewer.view(options);
	viewer.close();
```

{{< alert style="info" >}}GroupDocs.Viewer also provides an ability to customize rendering to HTML by setting additional options. To learn more about caching customization please refer to the following guides:HTML Viewer - Exclude fontsHTML Viewer - Minify HTMLHTML Viewer - Responsive layout{{< /alert >}}