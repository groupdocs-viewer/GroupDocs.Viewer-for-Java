---
id: how-to-substitute-missing-font-when-converting-presentations
url: viewer/java/how-to-substitute-missing-font-when-converting-presentations
title: How to substitute missing font when converting presentations
weight: 1
description: "In this article we show how to substitute missing font when converting presentations to HTML and PDF with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Background

In case your presentation document contains a font that is not installed into the system [GroupDocs.Viewer](https://products.groupdocs.com/viewer) will use a default font. [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) enables you to specify font substitution with [setDefaultFontName(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/BaseViewOptions#setDefaultFontName(java.lang.String)) setting.

## Font substitution

To set font substitution for missing fonts please use the following code:

When converting to HTML with embedded resources:

```java
    Viewer viewer = new Viewer("input.pptx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("output/html_embedded/p_{0}.html");
    viewOptions.setDefaultFontName("Times New Roman");
    viewer.view(viewOptions);
    viewer.close();
```

When converting to HTML with external resources:

```java
    Viewer viewer = new Viewer("input.pptx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forExternalResources();
    viewOptions.setDefaultFontName("Times New Roman");
    viewer.view(viewOptions);
    viewer.close();
```

Output HTML with default font:

![](viewer/java/images/how-to-substitute-missing-font-when-converting-presentations.png)

Output HTML with "Times New Roman" font:

![](viewer/java/images/how-to-substitute-missing-font-when-converting-presentations_1.png)

When converting to PDF:

```java
    Viewer viewer = new Viewer("input.pptx");
    PdfViewOptions viewOptions = new PdfViewOptions("output.pdf");
    viewOptions.setDefaultFontName("Times New Roman");
    viewer.view(viewOptions);
    viewer.close();
```

Output PDF with default font:

![](viewer/java/images/how-to-substitute-missing-font-when-converting-presentations_2.png)

Output PDF with "Times New Roman" font:

![](viewer/java/images/how-to-substitute-missing-font-when-converting-presentations_3.png)

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