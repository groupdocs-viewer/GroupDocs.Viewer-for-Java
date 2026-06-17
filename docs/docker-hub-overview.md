### GroupDocs Document Viewer API

[Product Page](https://products.groupdocs.com/viewer/java) | [Docs](https://docs.groupdocs.com/viewer/java/) | [Demos](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/viewer) | [Examples](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/viewer/) | [Free Support](https://forum.groupdocs.com/c/viewer) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

**GroupDocs.Viewer Demos** are applications that demonstrate powerful features of [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) distributed as Docker images. View **DOCX, PDF, PPT, XLS**, and over 170 document formats without additional dependencies. Search and select text from any document. Use these images as-is or customize and integrate them into your own project.

**Note:** without a license the application runs in trial mode. [Purchase a license](https://purchase.groupdocs.com/viewer/java) or request a [temporary license](https://purchase.groupdocs.com/temporary-license).

## Security Notice

These Docker images ship **sample/demo applications** — not production-ready services.

- Intended for **local development and evaluation** only
- Demo defaults enable upload, browse, and download; **no authentication** is included
- Do **not** expose port `8080` to untrusted networks without authentication, a reverse proxy, path validation, and other controls required by your organization
- For production, use the [GroupDocs.Viewer library](https://docs.groupdocs.com/viewer/java/) and implement your own secure document storage and API layer

Source code: [GroupDocs.Viewer-for-Java](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)

## Supported Document Formats

| Family | Formats |
| --- | --- |
| Portable Document Format | PDF |
| Microsoft Word | DOC, DOCM, DOCX, DOT, DOTM, DOTX |
| Microsoft Excel | XLS, XLSB, XLSM, XLSX, XLT, XLTM, XLTX |
| Microsoft PowerPoint | PPT, POT, POTM, POTX, PPS, PPSM, PPSX, PPTM, PPTX |
| Microsoft Visio | VSD, VDW, VDX, VSDX, VSS, VST, VSX, VTX |
| Microsoft Project | MPP, MPT |
| Microsoft Outlook | EML, EMLX, MSG |
| OpenDocument Formats | ODT, ODP, ODS, OTT |
| Plain Text | TXT |
| Comma-Separated Values | CSV |
| HyperText Markup Language | HTML, MHT, MHTML, SVG |
| Extensible Markup Language | XML, XPS |
| AutoCAD Drawing | DGN, DWG, DXF |
| Image files | BMP, CAL, DCX, DIB, EMF, GIF, JP2, JPG, MIL, PCD, PCT, PCX, PNG, PSD, RAS, TGA, TIFF, WMF |
| Electronic publication | EPUB |
| Windows Icon | ICO |
| Medical image files | DCM |

See the [full list of supported formats](https://docs.groupdocs.com/viewer/java/supported-document-formats/) in the documentation.

## Document Viewer Demo Features

- Clean, modern and intuitive design
- Responsive design and mobile support
- HTML and image rendering modes
- Open password-protected documents
- Text search and highlighting
- Download, upload, and print documents
- Rotate pages, zoom, thumbnails, and smooth navigation
- Cross-browser and cross-platform support

## Available Docker Images

Six images are published for each GroupDocs.Viewer for Java release: three Spring and three Dropwizard variants.

Tag format: `{version}-java-{jdk}-bullseye-{framework}`

Example: `{{VERSION}}-java-openjdk8-bullseye-dropwizard` — GroupDocs.Viewer for Java **{{VERSION}}**, Eclipse Temurin 8, Debian Bullseye, Dropwizard.

| Tag | JDK | Framework |
| --- | --- | --- |
| `{{VERSION}}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{{VERSION}}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{{VERSION}}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |
| `{{VERSION}}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{{VERSION}}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{{VERSION}}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |

The `latest` tag points to the `{{VERSION}}-java-openjdk18-bullseye-spring` variant when published with the **latest** workflow option.

## How to Run

Pull and run a Dropwizard image:

```shell
docker run -p 8080:8080 --name viewer --rm groupdocs/viewer:{{VERSION}}-java-openjdk8-bullseye-dropwizard
# Open http://localhost:8080/viewer/ in your browser.
```

Bind volumes for sample files and license:

```shell
docker run -p 8080:8080 --name viewer --rm \
  -v "C:/DocumentSamples/:/home/groupdocs/app/DocumentSamples" \
  -v "C:/Licenses/:/home/groupdocs/app/Licenses" \
  groupdocs/viewer:{{VERSION}}-java-openjdk8-bullseye-dropwizard
```

The sample reads license files from the mounted `Licenses` directory and lists documents from `DocumentSamples`.

## Viewer Configuration Options

Environment variables:

| Variable | Description | Default |
| --- | --- | --- |
| `LIC_PATH` | Path to directory with license file | `/home/groupdocs/app/Licenses` |
| `DOWNLOAD_ON` | Enable download button in UI | `true` |
| `UPLOAD_ON` | Enable file upload | `true` |
| `PRINT_ON` | Enable print | `true` |
| `BROWSE_ON` | Enable document browse dialog | `true` |
| `RIGHTCLICK_ON` | Enable right-click context menu | `false` |
| `FILES_DIR` | Directory for uploaded files | `/home/groupdocs/app/DocumentSamples` |
| `HOST_ADDRESS` | Host name or IP for the server instance | (empty) |

## See Also

- [Compare documents](https://products.groupdocs.com/comparison/java) with GroupDocs.Comparison
- [Sign documents](https://products.groupdocs.com/signature/java) with GroupDocs.Signature
- [Annotate documents](https://products.groupdocs.com/annotation/java) with GroupDocs.Annotation

[Product Page](https://products.groupdocs.com/viewer/java) | [Docs](https://docs.groupdocs.com/viewer/java/) | [Demos](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/viewer) | [Examples](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/viewer/) | [Free Support](https://forum.groupdocs.com/c/viewer) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
