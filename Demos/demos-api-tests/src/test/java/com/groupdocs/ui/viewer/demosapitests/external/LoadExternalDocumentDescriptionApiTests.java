package com.groupdocs.ui.viewer.demosapitests.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.ui.viewer.demosapitests.Constants;
import com.groupdocs.ui.viewer.demosapitests.cases.LoadDocumentDescription;
import com.groupdocs.ui.viewer.demosapitests.cases.LoadDocumentDescriptionCase;
import com.groupdocs.ui.viewer.demosapitests.common.Utils;
import io.restassured.http.ContentType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LoadExternalDocumentDescriptionApiTests {
    public static final int ERROR_MESSAGE_DATA_LENGTH = 128;
    public static final int ERROR_MESSAGE_DATA_LOOK_BACK = 16;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadExternalDocumentDescriptionApiTests.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final Pattern EXTERNAL_LINK_PATTERN = Pattern.compile("(?:src|href)=[\"']([^\"']+)[\"']");
    private final List<String> SKIP_RESOURCES_NAMES = Arrays.asList("filelist.xml", "editdata.mso", "oledata.mso");

    @DataProvider(name = "testLoadDocumentDescription_ExternalResources_DataProvider")
    public Object[][] testLoadDocumentDescription_ExternalResources_DataProvider() throws IOException {
        final java.net.URL documentDescriptionResource = this.getClass().getResource("");
        assertThat(documentDescriptionResource).isNotNull();

        List<Object[]> caseList = new ArrayList<>();

        final Path documentDescriptionDirectory = Paths.get(documentDescriptionResource.getPath().substring(1));

        for (Path filePath : Files.newDirectoryStream(documentDescriptionDirectory, "*.json")) {
//            if (filePath.toString().contains("xps-")) // To run one test
                caseList.add(new Object[]{filePath.toString()});
        }

        return caseList.toArray(new Object[0][]);
    }

    @Test(dataProvider = "testLoadDocumentDescription_ExternalResources_DataProvider")
    public void testLoadDocumentDescription(String caseFile) throws IOException {
        if (caseFile.contains("eml") || caseFile.contains("msg")) {
            throw new SkipException("ASPOSEJAVA-166");
        }

        LoadDocumentDescription expectedObject = null;
        LoadDocumentDescription actualObject = null;
        final Path caseFilePath = Paths.get(caseFile);
        try {
            final LoadDocumentDescriptionCase caseObject = OBJECT_MAPPER.readValue(caseFilePath.toFile(), LoadDocumentDescriptionCase.class);
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

                assertThat(actualPageDescriptionEntity.getAngle()).isEqualTo(expectedPageDescriptionEntity.getAngle());
                assertThat(actualPageDescriptionEntity.getHeight()).isEqualTo(expectedPageDescriptionEntity.getHeight());
                assertThat(actualPageDescriptionEntity.getWidth()).isEqualTo(expectedPageDescriptionEntity.getWidth());
                assertThat(actualPageDescriptionEntity.getNumber()).isEqualTo(expectedPageDescriptionEntity.getNumber());


                assertThat(expectedPageDescriptionEntity.getData() == null && actualPageDescriptionEntity.getData() != null)
                        .as("Actual data must be null but was not")
                        .isFalse();
                assertThat(expectedPageDescriptionEntity.getData() != null && actualPageDescriptionEntity.getData() == null)
                        .as("Actual data must NOT be null but was")
                        .isFalse();

                if (expectedPageDescriptionEntity.getData() != null) {
                    final String expectedData = Utils.normalizeDataBeforeComparing(expectedPageDescriptionEntity.getData());
                    final String actualData = Utils.normalizeDataBeforeComparing(actualPageDescriptionEntity.getData());

                    final int pageNumber = n + 1;
                    assertThat(actualData)
                            .withFailMessage(() -> {
                                        int startIndex = 0;
                                        while (startIndex < expectedData.length() && startIndex < actualData.length()
                                                && expectedData.charAt(startIndex) == actualData.charAt(startIndex)) {
                                            startIndex++;
                                        }
                                        return String.format("expected data of page %d to be \n'%s', \nbut was \n'%s'",
                                                pageNumber,
                                                expectedData.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(expectedData.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK)),
                                                actualData.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(actualData.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK))
                                        );
                                    }
                            )
                            .isEqualTo(expectedData);

                    final Map<Integer, Map<String, String>> externalData = caseObject.getExternalData();
                    final Map<String, String> externalPageResources = externalData.get(pageNumber);

                    final Matcher matcher = EXTERNAL_LINK_PATTERN.matcher(actualData);
                    Set<String> externalResourcesCount = new HashSet<>(); // To calculate only unique resources
                    // To prevent saving pages when the problem is in resources
                    actualObject = null;
                    expectedObject = null;

                    while (matcher.find()) {
                        final String externalRelativeLink = matcher.group(1);
                        if (externalRelativeLink.startsWith("http") // External links
                                || externalRelativeLink.startsWith("mailto:")
                                || externalRelativeLink.startsWith("data:")
                                || SKIP_RESOURCES_NAMES.contains(Paths.get(externalRelativeLink).getFileName().toString())) {
                            continue;
                        }
                        assertThat(externalRelativeLink)
                                .isNotBlank()
                                .as("External relative link")
                                .startsWith("/");
                        final String externalLink = Constants.URL_BASE + externalRelativeLink;
                        final URL url = new URL(externalLink);
                        try (final InputStream inputStream = url.openStream()) {
                            assertThat(externalPageResources)
                                    .withFailMessage("Resource '%s' is not in the list of expected resources for case %s (page %d)",
                                            externalRelativeLink,
                                            caseFilePath.getFileName().toString(),
                                            pageNumber)
                                    .containsKey(externalRelativeLink);

                            final String actualLinkContent = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                            final String expectedLinkContent = externalPageResources.get(externalRelativeLink);

                            assertThat(actualLinkContent)
                                    .isNotNull()
                                    .isNotBlank();


                            if (externalRelativeLink.endsWith(".png")) {
                                externalPageResources.put(externalRelativeLink, String.valueOf(actualLinkContent.length()));
                                final int expectedLinkContentLength = Integer.parseInt(expectedLinkContent);
                                assertThat(actualLinkContent)
                                        .withFailMessage("Resource content length (binary file) is expected to be %d, but was %d", expectedLinkContentLength, actualLinkContent.length())
                                        .hasSize(expectedLinkContentLength);
                            } else {
                                externalPageResources.put(externalRelativeLink, actualLinkContent);
                                assertThat(Utils.normalizeDataBeforeComparing(actualLinkContent))
                                        .withFailMessage(() -> {
                                                    int startIndex = 0;
                                                    while (startIndex < expectedLinkContent.length() && startIndex < actualLinkContent.length()
                                                            && expectedLinkContent.charAt(startIndex) == actualLinkContent.charAt(startIndex)) {
                                                        startIndex++;
                                                    }
                                                    return String.format("expected data of resource '%s' (page %d) to be \n'%s', \nbut was \n'%s'",
                                                            externalRelativeLink,
                                                            pageNumber,
                                                            expectedLinkContent.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(expectedLinkContent.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK)),
                                                            actualLinkContent.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(actualLinkContent.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK))
                                                    );
                                                }
                                        )
                                        .isEqualTo(Utils.normalizeDataBeforeComparing(expectedLinkContent));
                            }
                        }
                        externalResourcesCount.add(externalRelativeLink);
                    }
                    assertThat(externalResourcesCount.size())
                            .as("Expected external resources count")
                            .isEqualTo(externalPageResources.size());
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
                        FileUtils.write(expectedTempFile.toFile(), expectedPageDescriptionEntity.getData(), StandardCharsets.UTF_8);
                        LOGGER.info("Expected data for page {} was written:\t'{}'", n + 1, expectedTempFile);
                    }
                    if (actualPages.size() > n) {
                        final LoadDocumentDescription.PageDescriptionEntity actualPageDescriptionEntity = actualPages.get(n);
                        final Path actualTempFile = Files.createTempFile(Paths.get("target"), "LoadDocumentDescription-" + fileName.substring(0, fileName.lastIndexOf('.')) + "-actual-page-" + actualPageDescriptionEntity.getNumber() + "-", ".html");
                        FileUtils.write(actualTempFile.toFile(), actualPageDescriptionEntity.getData(), StandardCharsets.UTF_8);
                        LOGGER.info("Actual data for page {} was written:\t'{}'", n + 1, actualTempFile);
                    }
                }
            }
            throw e;
        } finally {
            System.out.println();
        }
    }
}
