---
id: how-to-get-the-names-of-the-worksheets
url: viewer/java/how-to-get-the-names-of-the-worksheets
title: How to get the names of the worksheets
weight: 2
description: "This article explains how to get names of the worksheets from Excel files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

Excel worksheets have names that are used to simplify navigation and make it possible to reference data from other worksheets. When you do create a new workbook in Excel it already has with the name "Sheet1".
I've created three worksheets and left their default names that is shown on the screenshot below.
![](viewer/java/images/how-to-get-the-names-of-the-worksheets.png)

## Retrieving the names of the worksheets

To get the names of the worksheets call [getViewInfo()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method that returns an object which contains a list of pages (worksheets). Each page has its name. 
The following code sample shows how to get and print out the names of the worksheets.

```java
    try (Viewer viewer = new Viewer("sample.xlsx")) {
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
        viewInfoOptions.setSpreadsheetOptions(SpreadsheetOptions.forOnePagePerSheet());
    
        ViewInfo viewInfo = viewer.getViewInfo(viewInfoOptions);
    
        System.out.println("Worksheets:");
        for (Page page : viewInfo.getPages()) {
            System.out.println(" - Worksheet " + page.getNumber() + " name '" + page.getName() + "'");
        }
    }       
```  
  
  
    
After running this sample code the names of the worksheets are printed into a console as shown on the screenshot below.
![](viewer/java/images/how-to-get-the-names-of-the-worksheets_1.png)

## More resources
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