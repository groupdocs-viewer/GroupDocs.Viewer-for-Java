# GroupDocs.Viewer for Java - Javalin Demo

A web-based document viewer built with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) and Javalin 4.6 (Kotlin).

Supports viewing 170+ document formats (DOCX, PDF, PPT, XLS, images, CAD, and more) as HTML5 or images. See the [full list of supported formats](https://docs.groupdocs.com/viewer/java/supported-document-formats/).

## System Requirements

- Java 8+ (JDK 1.8+)

## How to Run

#### From command line

```bash
git clone https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java.git
cd GroupDocs.Viewer-for-Java/Demos/Javalin
./gradlew run
```

Open http://localhost:8080/viewer/ in your browser.

#### From IDE

Open the project in your IDE, enable **Annotation processing** in settings, then run the `main` method in `Application.kt`.

#### Build distribution archive

```bash
./gradlew assembleDist
```

Distribution files will be in `build/distributions/`.

## Configuration

Edit `src/main/resources/application.conf` to adjust settings. Set `licensePath` in the config file or use the `LIC_PATH` environment variable.

| Option | Type | Default | Description |
|--------|------|---------|-------------|
| `filesDirectory` | String | `DocumentSamples` | Directory for uploaded and predefined files (absolute or relative path) |
| `tempDirectory` | String | system temp | Directory for temporary files |
| `resultDirectory` | String | `ResultFiles` | Directory for result files (must exist before startup) |

**Note:** Without a license, the application runs in [evaluation mode](https://docs.groupdocs.com/viewer/java/evaluation-limitations-and-licensing-of-groupdocs-viewer/). Request a [temporary license](https://purchase.groupdocs.com/temporary-license) to test all features.

## License

The MIT License (MIT). See [LICENSE](LICENSE) for details.

## Resources

[Product Page](https://products.groupdocs.com/viewer/java) | [Documentation](https://docs.groupdocs.com/viewer/java/) | [API Reference](https://apireference.groupdocs.com/java/viewer) | [Online Demo](https://products.groupdocs.app/viewer/family) | [Blog](https://blog.groupdocs.com/category/viewer/) | [Free Support](https://forum.groupdocs.com/c/viewer) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
