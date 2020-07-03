---
id: render-tracked-changes
url: viewer/java/render-tracked-changes
title: Render tracked changes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) does not render tracked changes of Word Processing documents by default. If you want to see tracked changes in your rendering result, use setter *htmlViewOptions.getWordProcessingOptions().setRenderTrackedChanges()*  (or *pngViewOptions*, or *jpgViewOptions*, or *pdfViewOptions*) and pass it to *Viewer* object constructor.

Follow below steps to render WordProcessing document with tracked changes.

*   Initialize the *HtmlViewOptions* object.
*   Set *wordProcessingOptions.setRenderTrackedChanges()* to *true*.
*   Pass *HtmlViewOptions* object to *view* method.

The following code sample shows how to render a Word document including tracked changes.

```java        
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.getWordProcessingOptions().setRenderTrackedChanges(true);
 
Viewer viewer = new Viewer("with_tracked_changes.docx");
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