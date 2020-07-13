---
id: view-archive-files
url: viewer/java/view-archive-files
title: View Archive Files
weight: 17
description: "This article contains use-cases of viewing Archives with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Overview

The archive files are used to compress files to save space on disk or compress files to group them. There are different compression algorithms are used to compress files that's why we have different archive formats. The most popular archive formats are ZIP and TAR and it's highly likely that you've already packed and unpacked archive files. 

## Supported Archive Formats

The following archive formats are supported by the [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java). 

Auto Detection means that [GroupDocs.Viewer](https://products.groupdocs.com/viewer) can determine the type of the archive file by reading the information in the file header.

| File Extension | File Type | Auto Detection |
| --- | --- | --- |
| [.ZIP](https://wiki.fileformat.com/compression/zip) | [Archive file format](https://wiki.fileformat.com/compression/zip) | Yes |
| [.TAR](https://wiki.fileformat.com/compression/tar) | [Consolidated Unix File Archive](https://wiki.fileformat.com/compression/tar) | Yes |
| [.BZ2](https://wiki.fileformat.com/compression/bz2) | [Bzip2 compressed file](https://wiki.fileformat.com/compression/bz2) | Yes |

*Note:* _to get actual information about supported formats it is recommended to call [getSupportedFileTypes()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/FileType#getSupportedFileTypes()) method of [FileType](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/FileType) class_

## In this section

The articles given in this section describes the usage of [GroupDocs.Viewer](https://products.groupdocs.com/viewer) to convert archive formats with different available options.
