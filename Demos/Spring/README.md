# GroupDocs.Viewer for Java - Spring Boot Demo

A web-based document viewer built with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) and Spring Boot 2.5.

Supports viewing 170+ document formats (DOCX, PDF, PPT, XLS, images, CAD, and more) as HTML5 or images. See the [full list of supported formats](https://docs.groupdocs.com/viewer/java/supported-document-formats/).

## System Requirements

- Java 8 (JDK 1.8)
- Maven 3

## How to Run

```bash
git clone https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java.git
cd GroupDocs.Viewer-for-Java/Demos/Spring
mvn clean spring-boot:run
```

Open http://localhost:8080/viewer/ in your browser.

To debug in IntelliJ IDEA, use `mvn clean spring-boot:run -Dspring-boot.run.fork=false`.

#### Build WAR

```bash
mvn package -P war
```

Deploy the generated WAR file from `target/` to your application server.

## Docker

Build and run locally:

```bash
docker build -t groupdocs-viewer-spring .
mkdir -p DocumentSamples Licenses
```

Linux / macOS:

```bash
docker run -p 8080:8080 \
  --env application.hostAddress=localhost \
  -v $(pwd)/DocumentSamples:/home/groupdocs/app/DocumentSamples \
  -v $(pwd)/Licenses:/home/groupdocs/app/Licenses \
  groupdocs-viewer-spring
```

Windows PowerShell:

```powershell
docker run -p 8080:8080 `
  --env application.hostAddress=localhost `
  -v ${PWD}/DocumentSamples:/home/groupdocs/app/DocumentSamples `
  -v ${PWD}/Licenses:/home/groupdocs/app/Licenses `
  groupdocs-viewer-spring
```

Pre-built images are also available on [Docker Hub](https://hub.docker.com/r/groupdocs/viewer). See the [main README](../../README.md#docker) for available tags.

## Configuration

Edit `configuration.yml` to adjust settings. Place your license file in the `Licenses/` folder or set `licensePath` in `configuration.yml`.

For Docker, use `logback-spring.xml` for logging. To use it locally, add `-Dlogback.configurationFile=logback-spring.xml` to the run command.

| Option | Type | Default | Description |
|--------|------|---------|-------------|
| `filesDirectory` | String | `DocumentSamples` | Directory for uploaded and predefined files (absolute or relative path) |
| `fontsDirectory` | String | | Path to custom fonts directory |
| `defaultDocument` | String | | Absolute path to document loaded automatically on startup |
| `preloadPageCount` | Integer | `0` | Pages to preload (`0` = load all at once) |
| `htmlMode` | Boolean | `true` | `true` for HTML rendering, `false` for image rendering |
| `zoom` | Boolean | `true` | Enable document zoom |
| `search` | Boolean | `true` | Enable text search |
| `thumbnails` | Boolean | `true` | Enable thumbnails preview |
| `rotate` | Boolean | `true` | Enable page rotation |
| `cache` | Boolean | `true` | Enable rendering cache |
| `saveRotateState` | Boolean | `true` | Persist page rotation to the file |
| `watermarkText` | String | | Watermark text overlay |

Options can also be set via environment variables, e.g. `application.viewer.htmlMode=false`.

**Note:** Without a license, the application runs in [evaluation mode](https://docs.groupdocs.com/viewer/java/evaluation-limitations-and-licensing-of-groupdocs-viewer/). Request a [temporary license](https://purchase.groupdocs.com/temporary-license) to test all features.

## License

The MIT License (MIT). See [LICENSE](LICENSE) for details.

## Resources

[Product Page](https://products.groupdocs.com/viewer/java) | [Documentation](https://docs.groupdocs.com/viewer/java/) | [API Reference](https://apireference.groupdocs.com/java/viewer) | [Online Demo](https://products.groupdocs.app/viewer/family) | [Blog](https://blog.groupdocs.com/category/viewer/) | [Free Support](https://forum.groupdocs.com/c/viewer) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
