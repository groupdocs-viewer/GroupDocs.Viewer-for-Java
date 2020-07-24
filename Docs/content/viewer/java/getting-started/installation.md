---
id: installation
url: viewer/java/installation
title: Installation
weight: 4
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://repository.groupdocs.com/). You can easily use [GroupDocs.Viewer for Java](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-viewer) API directly in your Maven projects with simple configurations.

### Specify GroupDocs Repository Configuration

First, you need to specify repository configuration/location in your Maven `pom.xml` as follows: 

```xml
<repositories>
	<repository>
		<id>GroupDocsArtifactRepository</id>
		<name>GroupDocs Artifact Repository</name>
		<url>https://repository.groupdocs.com/repo/</url>
	</repository>
</repositories>
```

### Define GroupDocs.Viewer for Java API Dependency

Then define [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) API dependency in your `pom.xml` as follows:

```xml
<dependencies>
    <dependency>
        <groupId>com.groupdocs</groupId>
        <artifactId>groupdocs-viewer</artifactId>
        <version>20.7</version> 
    </dependency>
</dependencies>
```
  
After performing the above-mentioned steps, [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) dependency will finally be added to your Maven project.

## Install from official GroupDocs website

You can follow the steps below to reference [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) downloaded from official website [Downloads section](https://downloads.groupdocs.com/viewer/java):

1.  Unpack zip archive .
2.  Switch to **lib** folder.
3.  Run **install.bat** (for Windows) or **install.sh** (for Linux) file to install the library in your local maven repository.
4.  After this you should add the [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) **dependency** block to your .pom.xml project file.
