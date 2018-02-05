package com.groupdocs.viewer.examples;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.domain.FileData;
import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.helper.IFileDataStore;

import java.io.*;

/**
 * @author Aleksey Permyakov (27.12.2016)
 */
public class S3DataStore implements IFileDataStore {
    private final AmazonS3Client amazonS3Client;

    public S3DataStore(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public FileData getFileData(FileDescription fileDescription) throws Exception {
        String objectKey = makeStoreName(fileDescription);

        GetObjectRequest request = new GetObjectRequest(Utilities.TEST_BUCKET, objectKey);
        try {
            final S3Object response = amazonS3Client.getObject(request);
            return deserialize(response.getObjectContent());
        } catch (AmazonS3Exception e) {
            return null;
        }
    }

    public void saveFileData(FileDescription fileDescription, FileData fileData) throws Exception {
//        String objectKey = makeStoreName(fileDescription);
//        final ByteArrayInputStream serialize = serialize(fileData);
//
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setContentLength(serialize.available());
//        PutObjectRequest request = new PutObjectRequest(Main.TEST_BUCKET, objectKey, serialize, objectMetadata);
//
//        final PutObjectResult putObjectResult = amazonS3Client.putObject(request);
//        putObjectResult.getExpirationTime();
    }

    @SuppressWarnings("unused")
	private ByteArrayInputStream serialize(FileData fileData) throws Exception {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(fileData);
        return new ByteArrayInputStream(json.getBytes());
    }

    private FileData deserialize(InputStream stream) throws Exception {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        final FileData fileData = gson.fromJson(new InputStreamReader(stream), FileData.class);
        stream.close();
        return fileData;
    }


    private String makeStoreName(FileDescription cacheFileDescription) {
        return combine("S3Store",
                        cacheFileDescription.getDocumentType(),
                        cacheFileDescription.getGuid());
    }

    public static String combine(String... pathParts) {
        StringBuilder builder = new StringBuilder();
        for (String pathPart : pathParts) {
            builder.append(pathPart).append(File.separator);
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
