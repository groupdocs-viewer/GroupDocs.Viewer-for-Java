# Document Viewer Java Library

GroupDocs.Viewer for Java is a [Document Viewer API](https://products.groupdocs.com/viewer/java) for Java developers. It supports over 140 document types from popular categories such as Microsoft Office, OpenOffice, AutoCAD, Photoshop, Visio, images, metafiles, programming, archives, messages, PDF & more.

View PDF, DOC, PPT, ODT, OTT, ODP among [many other documents](https://docs.groupdocs.com/viewer/java/supported-document-formats/) in HTML5, PDF or image modes with fast and high quality rendering. You may also choose your own rendering strategy by processing the document page-by-page, entire document at once or a custom page range. API also provides the ability to customize document appearance via additional rendering options to add watermarks, rotate or reorder pages, extract document text and much more!

<p align="center">
  <a title="Download complete GroupDocs.Viewer for Java source code" href="https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/archive/master.zip"> 
    <img src="https://camo.githubusercontent.com/11839cd752a2d367f3149c7bee1742b68e4a4d37/68747470733a2f2f7261772e6769746875622e636f6d2f4173706f73654578616d706c65732f6a6176612d6578616d706c65732d64617368626f6172642f6d61737465722f696d616765732f646f776e6c6f61645a69702d427574746f6e2d4c617267652e706e67" data-canonical-src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" style="max-width:100%;">
  </a>
</p>

Directory | Description
--------- | -----------
[Docs](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Docs)  | Product documentation containing the Developer's Guide, Release Notes and more.
[Examples](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 
[Showcases](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Showcases)  | Build Document Viewer Applications using GroupDocs.Viewer for Java. 

## View Documents As HTML, PDF or Images

- Display document content in any web-browser.
- View document pages separately.
- Rotate, reorder pages or [add watermarks](https://docs.groupdocs.com/viewer/java/add-text-watermark/).
- Customizable resource management options for CSS, fonts & images.
- Render all pages of a document as a single PDF.
- Boost document loading speed with configurable caching.
- Extract document text along with words' coordinates.
- Extract basic information about source documents such as file type, pages count and so on.
- Auto-detect document type.
- [Replace missing font](https://docs.groupdocs.com/viewer/java/replace-missing-font/) or use custom fonts for rendering.

## Get Started with GroupDocs.Viewer for Java

GroupDocs.Viewer for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already. 

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-viewer), so simply [configure](https://docs.groupdocs.com/viewer/java/installation/) your Maven project to fetch the dependencies automatically.

## Render DOCX As Responsive HTML

```java
Viewer viewer = new Viewer("sample.docx");
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
viewOptions.setRenderResponsive(true);
viewer.view(viewOptions);
viewer.close();
```

## View DOCX As Protected PDF

```java
Viewer viewer = new Viewer("sample.docx");
Security security = new Security();
security.setDocumentOpenPassword("o123");
security.setPermissionsPassword("p123");
security.setPermissions(Permissions.ALLOW_ALL ^ Permissions.DENY_PRINTING);

PdfViewOptions viewOptions = new PdfViewOptions(filePath);
viewOptions.setSecurity(security);

viewer.view(viewOptions);
viewer.close();
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/viewer/java) | [Documentation](https://docs.groupdocs.com/viewer/java/) | [Demo](https://products.groupdocs.app/viewer/family) | [API Reference](https://apireference.groupdocs.com/java/viewer) | [Examples](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/viewer/) | [Free Support](https://forum.groupdocs.com/c/viewer) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
