package com.groupdocs.ui.viewer.demosapitests.embedded;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.ui.viewer.demosapitests.Constants;
import com.groupdocs.ui.viewer.demosapitests.cases.LoadDocumentDescription;
import com.groupdocs.ui.viewer.demosapitests.cases.LoadDocumentDescriptionCase;
import com.groupdocs.ui.viewer.demosapitests.common.Utils;
import io.restassured.http.ContentType;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LoadEmbeddedDocumentDescriptionApiTests {
    public static final int ERROR_MESSAGE_DATA_LENGTH = 128;
    public static final int ERROR_MESSAGE_DATA_LOOK_BACK = 16;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadEmbeddedDocumentDescriptionApiTests.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @DataProvider(name = "testLoadDocumentDescription_EmbeddedResources_DataProvider")
    public Object[][] testLoadDocumentDescription_EmbeddedResources_DataProvider() throws IOException {
        final java.net.URL documentDescriptionResource = this.getClass().getResource("");
        assertThat(documentDescriptionResource).isNotNull();

        List<Object[]> caseList = new ArrayList<>();

        final Path documentDescriptionDirectory = Paths.get(documentDescriptionResource.getPath().substring(1));

        for (Path filePath : Files.newDirectoryStream(documentDescriptionDirectory, "*.json")) {
//            if (filePath.toString().contains("eml-"))
            caseList.add(new Object[]{filePath.toString()});
        }

        return caseList.toArray(new Object[0][]);
    }

    @Test(dataProvider = "testLoadDocumentDescription_EmbeddedResources_DataProvider")
    public void testLoadDocumentDescription(String caseFile) throws IOException {
        int pageNumber = 0;
        LoadDocumentDescription expectedObject = null;
        LoadDocumentDescription actualObject = null;
        final Path caseFilePath = Paths.get(caseFile);
        final LoadDocumentDescriptionCase caseObject = OBJECT_MAPPER.readValue(caseFilePath.toFile(), LoadDocumentDescriptionCase.class);
        try {
            final String sourceGuid = caseObject.getSourceGuid();
            final String sourcePassword = caseObject.getSourcePassword();
            expectedObject = caseObject.getExpectedObject();

            LOGGER.info("Case name: '{}', Document guid: '{}'", caseFilePath.getFileName().toString(), sourceGuid);

            actualObject = given()
                    .when()
                    .body(String.format("{ 'guid': '%s', 'password': '%s' }".replace('\'', '"'), sourceGuid, sourcePassword).replace("\"null\"", "null"))
                    .contentType(ContentType.JSON)
                    .post(Constants.URL_TEMPLATE, "loadDocumentDescription")
                    .then()
//                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .and().extract().body().as(LoadDocumentDescription.class);

            assertThat(actualObject).isNotNull();

            assertThat(actualObject.getGuid()).isEqualTo(expectedObject.getGuid());
            assertThat(actualObject.getPrintAllowed()).isEqualTo(expectedObject.getPrintAllowed());
            assertThat(actualObject.isShowGridLines()).isEqualTo(expectedObject.isShowGridLines());

            final List<LoadDocumentDescription.PageDescriptionEntity> expectedPages = expectedObject.getPages();
            final List<LoadDocumentDescription.PageDescriptionEntity> actualPages = actualObject.getPages();

            assertThat(expectedPages).isNotNull();
            assertThat(actualPages).isNotNull();

            assertThat(actualPages)
                    .as("Pages count")
                    .hasSameSizeAs(expectedPages);
            for (int n = 0; n < actualPages.size(); n++) {
                final LoadDocumentDescription.PageDescriptionEntity expectedPageDescriptionEntity = expectedPages.get(n);
                final LoadDocumentDescription.PageDescriptionEntity actualPageDescriptionEntity = actualPages.get(n);
                ;
                pageNumber = n + 1;

                assertThat(actualPageDescriptionEntity.getAngle())
                        .as("Angle")
                        .isEqualTo(expectedPageDescriptionEntity.getAngle());
                assertThat(actualPageDescriptionEntity.getHeight())
                        .as("Height")
                        .isEqualTo(expectedPageDescriptionEntity.getHeight());
                assertThat(actualPageDescriptionEntity.getWidth())
                        .as("Width")
                        .isEqualTo(expectedPageDescriptionEntity.getWidth());
                assertThat(pageNumber)
                        .as("Number")
                        .isEqualTo(expectedPageDescriptionEntity.getNumber());

                assertThat(expectedPageDescriptionEntity.getData() == null && actualPageDescriptionEntity.getData() != null)
                        .as("Actual data must be null but was not")
                        .isFalse();
                assertThat(expectedPageDescriptionEntity.getData() != null && actualPageDescriptionEntity.getData() == null)
                        .as("Actual data must NOT be null but was")
                        .isFalse();

                if (expectedPageDescriptionEntity.getData() != null) {
                    final String expectedData = Utils.normalizeDataBeforeComparing(expectedPageDescriptionEntity.getData());
                    final String actualData = Utils.normalizeDataBeforeComparing(actualPageDescriptionEntity.getData());

                    final float diff = Utils.differenceOfStrings(actualData, expectedData);
                    final int finalPageNumber = pageNumber;
                    assertThat(diff)
                            .withFailMessage(() -> {
                                        int startIndex = 0;
                                        while (startIndex < expectedData.length() && startIndex < actualData.length()
                                                && expectedData.charAt(startIndex) == actualData.charAt(startIndex)) {
                                            startIndex++;
                                        }
                                        return String.format("expected data of page %d to be \n'%s', \nbut was \n'%s'",
                                                finalPageNumber,
                                                expectedData.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(expectedData.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK)),
                                                actualData.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(actualData.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK))
                                        );
                                    }
                            )
                            .isLessThan(0.1f); // 10% difference is allowed, because of minor differences in base64 encoded images
                }
            }

        } catch (AssertionError e) {
            if (expectedObject != null && actualObject != null) {
                final String fileName = caseFilePath.getFileName().toString();
                final List<LoadDocumentDescription.PageDescriptionEntity> expectedPages = expectedObject.getPages();
                final List<LoadDocumentDescription.PageDescriptionEntity> actualPages = actualObject.getPages();
                for (int n = 0; n < Math.max(expectedPages.size(), actualPages.size()); n++) {
                    if (expectedPages.size() > n) {
                        final LoadDocumentDescription.PageDescriptionEntity expectedPageDescriptionEntity = expectedPages.get(n);
                        final Path expectedTempFile = Files.createTempFile(Paths.get("target"), "LoadDocumentDescription-" + fileName.substring(0, fileName.lastIndexOf('.')) + "-expected-page-" + expectedPageDescriptionEntity.getNumber() + "-", ".html");
                        FileUtils.write(expectedTempFile.toFile(), Utils.normalizeDataBeforeComparing(expectedPageDescriptionEntity.getData()), StandardCharsets.UTF_8);
                        LOGGER.info("Expected data for page {} was written:\t'{}'", n + 1, expectedTempFile);
                    }
                    if (actualPages.size() > n) {
                        final LoadDocumentDescription.PageDescriptionEntity actualPageDescriptionEntity = actualPages.get(n);
                        final Path actualTempFile = Files.createTempFile(Paths.get("target"), "LoadDocumentDescription-" + fileName.substring(0, fileName.lastIndexOf('.')) + "-actual-page-" + actualPageDescriptionEntity.getNumber() + "-", ".html");
                        FileUtils.write(actualTempFile.toFile(), Utils.normalizeDataBeforeComparing(actualPageDescriptionEntity.getData()), StandardCharsets.UTF_8);
                        LOGGER.info("Actual data for page {} was written:\t'{}'", n + 1, actualTempFile);
                    }
                }
//                caseObject.getExpectedObject().getPages().clear();
//                caseObject.getExpectedObject().getPages().addAll(actualPages);
//                OBJECT_MAPPER.writeValue(new File("D:\\java\\groupdocs-viewer-java-examples\\Demos\\demos-api-tests\\src\\test\\resources\\com\\groupdocs\\ui\\viewer\\demosapitests\\embedded\\" + caseFilePath.getFileName()), caseObject);
            } else {
                System.out.println("Problematic page: " + pageNumber);
            }
            throw e;
        } finally {
            System.out.println();
        }
    }
}
