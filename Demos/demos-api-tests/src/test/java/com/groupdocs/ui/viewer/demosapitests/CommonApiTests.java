package com.groupdocs.ui.viewer.demosapitests;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Run a demo application with environment variable FILES_DIR=D:\groupdocs\files\api-viewer-tests
 * Clear cache
 * Configure the demo application to embed resources
 */
public class CommonApiTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonApiTests.class);
    private static final ClassLoader CLASS_LOADER = CommonApiTests.class.getClassLoader();

    @Test
    public void testRoot() {
        given()
                .when()
                .contentType(ContentType.HTML)
                .get(Constants.URL_TEMPLATE, "")
                .then().log().all()
                .assertThat()
                .statusCode(200)

                .body("html.head.title", Matchers.containsString("GroupDocs.Viewer for Java"))
                .body("html.body.script[0].@src", Matchers.containsString("/angular/viewer/runtime-es2015.js"))
                .body("html.body.script[1].@src", Matchers.containsString("/angular/viewer/polyfills-es2015.js"))
                .body("html.body.script[2].@src", Matchers.containsString("/angular/viewer/runtime-es5.js"))
                .body("html.body.script[3].@src", Matchers.containsString("/angular/viewer/polyfills-es5.js"))
                .body("html.body.script[4].@src", Matchers.containsString("/angular/viewer/styles-es2015.js"))
                .body("html.body.script[5].@src", Matchers.containsString("/angular/viewer/styles-es5.js"))
                .body("html.body.script[6].@src", Matchers.containsString("/angular/viewer/vendor-es2015.js"))
                .body("html.body.script[7].@src", Matchers.containsString("/angular/viewer/main-es2015.js"))
                .body("html.body.script[8].@src", Matchers.containsString("/angular/viewer/vendor-es5.js"))
                .body("html.body.script[9].@src", Matchers.containsString("/angular/viewer/main-es5.js"))
        ;
    }

    @Test
    public void testLoadConfig() {
        JsonPath expectedJson = new JsonPath(CLASS_LOADER.getResource("load_config.json"));

        final String actualString = given()
                .when()
                .contentType(ContentType.JSON)
                .get(Constants.URL_TEMPLATE, "loadConfig")
                .then()
//                .log().all()
                .assertThat()
                .statusCode(200)
                .and().extract().body().asString();

        final JsonPath actualJson = new JsonPath(actualString);

        final LoadConfigResponse expectedObject = expectedJson.getObject("", LoadConfigResponse.class);
        final LoadConfigResponse actualObject = actualJson.getObject("", LoadConfigResponse.class);

        // Files directory can be different
        expectedObject.setFilesDirectory(null);
        actualObject.setFilesDirectory(null);

        assertThat(actualObject).isEqualTo(expectedObject);
    }

    @Test
    public void testLoadFileTree() {
        JsonPath expectedJson = new JsonPath(CLASS_LOADER.getResource("load_file_tree.json"));

        final String actualString = given()
                .when()
                .body("{'path':''}".replace('\'', '"'))
                .contentType(ContentType.JSON)
                .post(Constants.URL_TEMPLATE, "loadFileTree")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and().extract().body().asString();

        final JsonPath actualJson = new JsonPath(actualString);

        final List<LoadFileTreeResponse> expectedObject = expectedJson.getObject("", new TypeRef<List<LoadFileTreeResponse>>() {
        });
        final List<LoadFileTreeResponse> actualObject = actualJson.getObject("", new TypeRef<List<LoadFileTreeResponse>>() {
        });

        assertThat(actualObject).isEqualTo(expectedObject);
    }

    @Test
    public void testRotateDocumentPages_minus90() {
        testRotateDocumentPages(-90);
    }

    @Test
    public void testRotateDocumentPages_plus90() {
        testRotateDocumentPages(90);
    }

    private void testRotateDocumentPages(int angle) {
        JsonPath expectedJson = new JsonPath(CLASS_LOADER.getResource("rotate_document_pages-" + angle + ".json"));

        // Make loadDocumentDescription to generate cache
        given()
                .when()
                .body("{ 'guid': 'GroupDocs_Demo.pdf', 'password': null }".replace('\'', '"'))
                .contentType(ContentType.JSON)
                .post(Constants.URL_TEMPLATE, "loadDocumentDescription")
                .then()
//                .log().all()
                .assertThat()
                .statusCode(200);

        // Rotation request
        final String actualString = given()
                .when()
                .body(("{" +
                        "'guid': 'GroupDocs_Demo.pdf'," +
                        "'password': null," +
                        "'pages': [1]," +
                        "'angle': " + angle +
                        "}").replace('\'', '"'))
                .contentType(ContentType.JSON)
                .post(Constants.URL_TEMPLATE, "rotateDocumentPages")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and().extract().body().asString();

        final JsonPath actualJson = new JsonPath(actualString);

        final RotatePageResponse expectedObject = expectedJson.getObject("", RotatePageResponse.class);
        final RotatePageResponse actualObject = actualJson.getObject("", RotatePageResponse.class);

        // Data is unstable, need more investigation
        expectedObject.setData(null);
        actualObject.setData(null);

        assertThat(actualObject).isEqualTo(expectedObject);
    }

    @Test
    public void testDownloadDocument() {
        given()
                .when()
                .param("path", "GroupDocs_Demo.pdf")
                .get(Constants.URL_TEMPLATE, "downloadDocument")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and().header("Content-disposition", Matchers.equalTo("attachment; filename=GroupDocs_Demo.pdf"));
    }

    @Test
    public void testPrintPdf() {

        given()
                .when()
                .body(("{" +
                        "'guid':'GroupDocs_Demo.pdf'," +
                        "'password':null" +
                        "}").replace('\'', '"'))
                .contentType(ContentType.JSON)
                .post(Constants.URL_TEMPLATE, "printPdf")
                .then()
                .assertThat()
                .statusCode(200)
                .and().header("Content-disposition", Matchers.equalTo("attachment; filename=GroupDocs_Demo.pdf"))
                .and().header("Content-Type", "application/pdf");
    }
}
