package com.groupdocs.viewer.examples;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.groupdocs.viewer.common.IDisposable;
import com.groupdocs.viewer.domain.cache.CacheFileDescription;
import com.groupdocs.viewer.domain.cache.CachedPageDescription;
import com.groupdocs.viewer.domain.cache.CachedPageResourceDescription;
import com.groupdocs.viewer.handler.cache.ICacheDataHandler;
import com.groupdocs.viewer.storage.FileInfo;
import com.groupdocs.viewer.storage.IFileInfo;
import com.groupdocs.viewer.storage.IFileStorage;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
public class AmazonS3FileStorage implements IFileStorage, IDisposable
{
    private AmazonS3Client _client;
    private String _bucketName;
 
    private char getPathDelimiter()
    {
        return '/';
    }
 
    public AmazonS3FileStorage(AmazonS3Client client, String bucketName)
    {
        _client = client;
        _bucketName = bucketName;
    }
 
    public boolean fileExists(String path)
    {
        try
        {
            String key = getKey(path);
            GetObjectMetadataRequest request = new GetObjectMetadataRequest(_bucketName, key);
            _client.getObjectMetadata(request);
            return true;
        }
        catch (AmazonS3Exception e)
        {
            return false;
        }
    }
 
    public InputStream getFile(String path)
    {
        String key = getKey(path);
        GetObjectRequest request = new GetObjectRequest(_bucketName, key);
        try (S3Object response = _client.getObject(request))
        {
            byte[] data = IOUtils.toByteArray(response.getObjectContent());
            return new ByteArrayInputStream(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public void saveFile(String path, InputStream content)
    {
        String key = getKey(path);
        PutObjectRequest request = new PutObjectRequest(_bucketName, key, content, new ObjectMetadata());
        _client.putObject(request);
    }
    public void deleteDirectory(String path)
    {
        String key = getKey(path);
        DeleteObjectRequest directory = new DeleteObjectRequest(_bucketName, key);
        _client.deleteObject(directory);
    }
 
    public IFileInfo getFileInfo(String path)
    {
        String key = getKey(path);
        GetObjectMetadataRequest request = new GetObjectMetadataRequest(_bucketName, key);
 
        ObjectMetadata response = _client.getObjectMetadata(request);
        IFileInfo file = new FileInfo();
        file.setPath(path);
        file.setSize(((ObjectMetadata) response).getContentLength());
        file.setLastModified(response.getLastModified());
        file.setDirectory(false);
        return file;
    }
 
    public List<IFileInfo> getFilesInfo(String path)
    {
        String key = getKey(path);
        ListObjectsRequest request = new ListObjectsRequest();
        request.setBucketName(_bucketName);
        request.setPrefix(key.length() > 1 ? key : "");
        request.setDelimiter(File.pathSeparator);
        ObjectListing response = _client.listObjects(request);
        List<IFileInfo> files = new ArrayList();
 
        // add directories
        for (String directory : response.getCommonPrefixes())
        {
            IFileInfo file = new FileInfo();
            file.setPath(directory);
            file.setDirectory(true);
            files.add(file);
        }
 
        // add files
        for (S3ObjectSummary entry : response.getObjectSummaries())
        {
            IFileInfo fileDescription = new FileInfo();
            fileDescription.setPath(entry.getKey());
                    fileDescription.setDirectory(false);
                    fileDescription.setLastModified(entry.getLastModified());
                    fileDescription.setSize(entry.getSize());
            files.add(fileDescription);
        }
        return files;
    }
 
    private String getKey(String path)
    {
        return path.replaceAll("\\+", File.pathSeparator).trim();
    }
 
    public void dispose()
    {
        if (_client != null)
        {
            _client = null;
        }
    }
}