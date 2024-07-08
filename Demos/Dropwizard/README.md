![Document viewer](https://raw.githubusercontent.com/groupdocs-viewer/groupdocs-viewer.github.io/master/resources/image/banner.png "GroupDocs.Viewer")
# GroupDocs.Viewer for Java Dropwizard Example
###### version 24.6

[![GitHub license](https://img.shields.io/github/license/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard.svg)](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard/blob/master/LICENSE)


## System Requirements
- Java 8+ (JDK 1.8)
- Maven 3


## Document Viewer API for Java Dropwizard

[GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) API allows you to view over 170 document formats including **DOCX**, **PDF**, **PPT**, **XLS**, among many others without any additional dependencies. Thanks to its flexible configuration it can be configured to **view documents as images or as HTML5**.


In order to demonstrate GroupDocs.Viewer for Java reach and powerful features we prepared a modern **document viewer** front-end web UI example. Which can be used as a standalone application or easily integrated into your project.

**Note:** without a license application will run in trial mode, purchase [GroupDocs.Viewer for Java license](https://purchase.groupdocs.com/order-online-step-1-of-8.aspx) or request [GroupDocs.Viewer for Java temporary license](https://purchase.groupdocs.com/temporary-license).

## Supported document Formats

| Family                      | Formats                                                                                                                            |
| --------------------------- |:---------------------------------------------------------------------------------------------------------------------------------- |
| Archive formats             | `ZIP`, `TAR`, `BZ2`, `RAR`, `GZIP`                                                                                                 |
| Apple formats               | `Numbers` 																														   |
| PDF formats                 | `PDF`, `XPS`, `OXPS`, `TEX`                                                                                                        |
| CAD formats                 | `DXF`, `DWG` , `DWT`, `STL`, `IFC`,`DWF` , `DWFX`, `DGN`, `PLT`,`CF2`,`OBJ`, `HPG`, `IGS`                                          |
| Microsoft Word              | `DOC`, `DOCM` , `DOCX`, `DOT`, `DOTM`, `DOTX`,`RTF`                                                                                      |
| Microsoft Excel             | `XLS`, `XLSB`, `XLSM`, `XLSX`, `XLT`, `XLTM`, `XLTX`,`Excel 2003 XML`,`XLAM`                                                       |
| Microsoft PowerPoint        | `PPT`, `POT`, `POTM`, `POTX`, `PPS`, `PPSM`, `PPSX`, `PPTM`, `PPTX`                                                                |
| Microsoft Visio             | `VSD`,`VSDX`,`VSDM`,`VDW`, `VDX`, `VSDX`, `VSS`,`VSSX`,`VSSM`,`VST`,`VSTX`, `VSX`, `VTX`,`VSTM`                                    |
| Microsoft Project           | `MPP`, `MPT`,`MPX`                                                                                                                 |
| Help files                  | `CHM`                                                                                                                              | 
| Email formats               | `EML`, `EMLX`, `MSG`, `NSF`, `MBOX`, `PST`,`OST`, `VCF`                                                                                   |
| OpenDocument Formats        | `ODT`, `ODP`,`FODP`, `ODS`,`FODS`, `OTT`,`OTS`,`ODG`,`FODG`,`OTG`,`OTP`,`SXC`                                                      |
| Plain Text File             | `TXT`,`TSV`                                                                                                                       |
| Comma-Separated Values      | `CSV`                                                                                                                              |
| HyperText Markup Language   | `HTML`, `MHT`, `MHTML`, `SVG`,`SVGZ`                                                                                               |
| Extensible Markup Language  | `XML`,`XML`, `XPS`                                                                                                                 |
| AutoCAD Drawing File Format | `DGN`, `DWG`, `DXF`                                                                                                                |
| Image files                 | `BMP`, `CAL`, `DCX`,`CGM`,`PCL`,`PSB`, `DIB`, `EMF`,`EMZ`,`WEBP`,`DNG`,`CDR`,`CMX`, `GIF`, `JP2`, `JPG`,`JPF`,`JPM`,`J2C`,`J2K`,`JPC`,`JPX`,`MIL`, `MIL`, `PCD`, `PCT`, `PCX`, `PNG`,`Animated PNG`, `PSD`,`PS`, `RAS`, `TGA`,`TIFF`,`WMF`,`WMZ`,`EPS`, `AI`  |
| Electronic publication      | `EPUB`,`MOBI`,`DJVU`                                                                                                                       |
| Windows Icon                | `ICO`                                                                                                                              |
| Medical image files         | `DCM`
| Programming Language Formats | `AS`, `AS3`, `ASM`, `BAT`, `C`, `CC`, `CMAKE`, `CPP`, `CS`,`VB`, `CSS`, `CXX`, `DIFF`, `ERB`, `GROOVY`, `H`, `HAML`, `HH`, `JAVA`, `JS`, `JSON`, `LESS`, `LOG`, `M`, `MAKE`, `MD`, `ML`, `MM`, `PHP`, `PL`, `PROPERTIES`, `PY`, `RB`, `RST`, `SASS`, `SCALA`, `SCM`, `SCRIPT`, `SH`, `SML`, `SQL`, `VIM`, `YAML`

## Demo Video

<p align="center">
  <a title="Document viewer for JAVA " href="https://www.youtube.com/watch?v=NnZaMNUC6o0"> 
    <img src="https://raw.githubusercontent.com/groupdocs-viewer/groupdocs-viewer.github.io/master/resources/image/document-viewer-demo.gif" width="100%" style="width:100%;">
  </a>
</p>


## Features
- Clean, modern and intuitive design
- Easily switchable colour theme (create your own colour theme in 5 minutes)
- Responsive design
- Mobile support (open application on any mobile device)
- Support over 90 documents and image formats including popular MS Office (Word, Excel, PowerPoint)
- HTML and image document viewing modes
- Fully customizable navigation panel
- Open password protected documents
- Text searching & highlighting
- Download documents
- Upload documents
- Print document
- Rotate pages
- Zoom in/out documents without quality loss in HTML mode
- Thumbnails
- Smooth page navigation
- Smooth document scrolling
- Preload pages for faster document viewing
- Multi-language support for displaying errors
- Display two or more pages side by side (when zooming out)
- Cross-browser support (Safari, Chrome, Opera, Firefox)
- Cross-platform support (Windows, Linux, MacOS)


## How to run

You can run this sample by one of following methods

#### Build from source

Download [source code](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard/archive/master.zip) from github or clone this repository.

```bash
git clone https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard
cd GroupDocs.Viewer-for-Java-Dropwizard
mvn clean compile exec:java
## Open http://localhost:8080/viewer/ in your favorite browser.
```

#### Binary release (with all dependencies)

Download [latest release](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard/releases/latest) from [releases page](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard/releases). 

**Note**: This method is **recommended** for running this sample behind firewall.

```bash
curl -J -L -o release.tar.gz https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard/releases/download/1.14.27/release.tar.gz
tar -xvzf release.tar.gz
cd release
java -jar viewer-1.14.27.jar configuration.yaml
## Open http://localhost:8080/viewer/ in your favorite browser.
```

#### Docker image
Use [docker](https://www.docker.com/) image.

```bash
mkdir DocumentSamples
mkdir Licenses
docker run -p 8080:8080 --env application.hostAddress=localhost -v `pwd`/DocumentSamples:/home/groupdocs/app/DocumentSamples -v `pwd`/Licenses:/home/groupdocs/app/Licenses groupdocs/viewer
## Open http://localhost:8080/viewer/ in your favorite browser.
```
### Configuration
For all methods above you can adjust settings in `configuration.yml`. By default in this sample will lookup for license file in `./Licenses` folder, so you can simply put your license file in that folder or specify relative/absolute path by setting `licensePath` value in `configuration.yml`. 

#### Viewer configuration options

| Option                 | Type    |   Default value   | Description                                                                                                                                  |
| ---------------------- | ------- |:-----------------:|:-------------------------------------------------------------------------------------------------------------------------------------------- |
| **`filesDirectory`**   | String  | `DocumentSamples` | Files directory path. Indicates where uploaded and predefined files are stored. It can be absolute or relative path                          |
| **`fontsDirectory`**   | String  |                   | Path to custom fonts directory.                                                                                                              |
| **`defaultDocument`**  | String  |                   | Absolute path to default document that will be loaded automaticaly.                                                                          |
| **`preloadPageCount`** | Integer |        `0`        | Indicate how many pages from a document should be loaded, remaining pages will be loaded on page scrolling.Set `0` to load all pages at once |
| **`htmlMode`**         | Boolean |      `true`       | HTML rendering mode. Set `false` to view documents in image mode. Set `true` to view documents in HTML mode                                  | 
| **`zoom`**             | Boolean |      `true`       | Enable or disable Document zoom                                                                                                              |
| **`search`**           | Boolean |      `true`       | Enable or disable document search                                                                                                            |
| **`thumbnails`**       | Boolean |      `true`       | Enable thumbnails preview                                                                                                                    |
| **`rotate`**           | Boolean |      `true`       | Enable individual page rotation functionality                                                                                                |
| **`cache`**            | Boolean |      `true`       | Set true to enable cache                                                                                                                     |
| **`saveRotateState`**  | Boolean |      `true`       | If enabled it will save chages made by rotating individual pages to same file.                                                               |
| **`watermarkText`**    | String  |                   | Text which will be used as a watermark                                                                                                       |


## License
The MIT License (MIT). 

Please have a look at the LICENSE.md for more details

## GroupDocs Document Viewer on other platforms/frameworks

- JAVA Sprint Boot [Document Viewer](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring) 
- .NET MVC [Document viewer](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-MVC)
- .NET WebForms [Document viewer](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/viewer/java) | [Documentation](https://docs.groupdocs.com/viewer/java/) | [Demos](https://products.groupdocs.app/viewer/family) | [API Reference](https://apireference.groupdocs.com/java/viewer) | [Examples](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/viewer/) | [Free Support](https://forum.groupdocs.com/c/viewer) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
