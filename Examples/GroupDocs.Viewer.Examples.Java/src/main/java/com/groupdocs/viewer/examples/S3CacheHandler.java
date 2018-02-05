package com.groupdocs.viewer.examples;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.model.*;
import com.groupdocs.viewer.domain.cache.CacheFileDescription;
import com.groupdocs.viewer.domain.cache.CachedPageDescription;
import com.groupdocs.viewer.domain.cache.CachedPageResourceDescription;
import com.groupdocs.viewer.handler.cache.ICacheDataHandler;
  

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
/**
 * @author Aleksey Permyakov (26.12.2016)
 */
public class S3CacheHandler implements ICacheDataHandler {
    private final String TEXT_BUCKET = "viewerjava1205";

    private final AmazonS3Client amazonS3Client;

    public S3CacheHandler(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public boolean exists(CacheFileDescription cacheFileDescription) {
        String guid = cacheFileDescription.getGuid();
        String baseName = cacheFileDescription.getBaseName();
        String extension = cacheFileDescription.getFileType();

        return doesObjectExist(guid);
    }
 
    public InputStream getInputStream(CacheFileDescription cacheFileDescription) {
        String guid = cacheFileDescription.getGuid();
        String baseName = cacheFileDescription.getBaseName();
        String extension = cacheFileDescription.getFileType();

        final S3Object object = amazonS3Client.getObject(new GetObjectRequest(TEXT_BUCKET, guid));

        return object.getObjectContent();
    }

    
    public OutputStream getOutputSaveStream(CacheFileDescription cacheFileDescription) {
        String guid = cacheFileDescription.getGuid();
        String baseName = cacheFileDescription.getBaseName();
        String extension = cacheFileDescription.getFileType();

        AmazonS3OutputStream outputStream = new AmazonS3OutputStream(cacheFileDescription, guid);
        return outputStream;
    }

    
    public Date getLastModificationDate(CacheFileDescription cacheFileDescription) throws Exception {
        String guid = cacheFileDescription.getGuid();
        String baseName = cacheFileDescription.getBaseName();
        String extension = cacheFileDescription.getFileType();

        try {
            final ObjectMetadata object = amazonS3Client.getObjectMetadata(new GetObjectMetadataRequest(TEXT_BUCKET, guid));
            return object.getLastModified();
        } catch (Exception ignored) {
            return null;
        }

}

   
    public String getHtmlPageResourcesFolder(CachedPageDescription cachedPageDescription) throws Exception {
        return null;
    }

    
    public List<CachedPageResourceDescription> getHtmlPageResources(CachedPageDescription cachedPageDescription) throws Exception {
        return null;
    }

     
    public String getFilePath(CacheFileDescription cacheFileDescription) throws Exception {
        return null;
    }

    
    public void clearCache(long l) throws Exception {

    }

    /**
     * Tests whether a file exists based on its key.
     */
    boolean doesObjectExist(String key) {
        try {
            final ObjectMetadata object = amazonS3Client.getObjectMetadata(new GetObjectMetadataRequest(TEXT_BUCKET, key));
        } catch (AmazonS3Exception e) {
            if (e.getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                return false;
            } else {
                e.printStackTrace();
            }
        }
        return true;
    }

    /*
    * Followed http://stackoverflow.com/questions/31805518/how-to-upload-a-java-outputstream-to-aws-s3
    *
    */
    private class AmazonS3OutputStream extends ByteArrayOutputStream {

        private CacheFileDescription cacheFileDescription;
        private String key;

        public AmazonS3OutputStream(CacheFileDescription cacheFileDescription, String key) {
            super();

            this.cacheFileDescription = cacheFileDescription;
            this.key = key;
        }

        //Create InputStream without actually copying the buffer and using up mem for that.
        public InputStream toInputStream() {
            return new ByteArrayInputStream(buf, 0, count);
        }

        public void close() throws IOException {
            super.close();

            String filename = cacheFileDescription.getName();
            String mimeType = Mimetypes.getInstance().getMimetype(filename);
            long length = cacheFileDescription.getSize();

            final InputStream inputStream = toInputStream();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentDisposition("inline; filename=\"${filename}\"");
            metadata.setContentType(mimeType);
            metadata.setLastModified(new Date());
            metadata.setContentLength(length);

            PutObjectRequest request = new PutObjectRequest(TEXT_BUCKET, key, inputStream, metadata);
            amazonS3Client.putObject(request.withCannedAcl(CannedAccessControlList.Private));
        }
    }
}
