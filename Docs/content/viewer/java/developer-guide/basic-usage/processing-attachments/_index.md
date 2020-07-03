---
id: processing-attachments
url: viewer/java/processing-attachments
title: Processing attachments
weight: 4
description: "This documentation section describes how to view, print or extract PDF, Outlook email and Archive document attachments with file viewer y GroupDocs."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Some files such as Email documents, Outlook data files, Archives and PDF documents may contain attachments, those attachments can be viewed, extracted or printed with help of [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) for Java API.

In order to access document attachment use [getAttachments()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#getAttachments()) method of [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) object. Just follow steps below:

*   Instantiate [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) object for the file that contains attachment(s);
*   Call [getAttachments()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#getAttachments()) method which will return document attachments collection;
*   Process attachments according to your needs (print a list of attachment names, save or view attachments, etc.)

See following examples on how to process document attachments in more details:

