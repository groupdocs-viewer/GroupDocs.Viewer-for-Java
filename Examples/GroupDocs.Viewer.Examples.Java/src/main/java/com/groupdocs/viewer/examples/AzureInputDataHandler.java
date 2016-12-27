package com.groupdocs.viewer.examples;

import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

import com.microsoft.azure.storage.blob.*;
import com.microsoft.azure.storage.*;
import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.domain.cache.CachedDocumentDescription;
import com.groupdocs.viewer.domain.options.FileTreeOptions;
import com.groupdocs.viewer.exception.GroupDocsException;
import com.groupdocs.viewer.handler.input.IInputDataHandler;

// ExStart: AzureInputDataHandler
public class AzureInputDataHandler implements IInputDataHandler {
    private static final String Delimiter = "/";
    private static final String EndpointTemplate = "https://{account-name}.blob.core.windows.net/";
    private final CloudBlobContainer _container;
  
    public AzureInputDataHandler(String accountName, String accountKey, String containerName) throws URISyntaxException {
        this(GetEndpoint(accountName), accountName, accountKey, containerName);
 
    }
  
    public AzureInputDataHandler(URI endpoint, String accountName, String accountKey, String containerName)
    {
        try
        {
            StorageCredentials storageCredentials = new StorageCredentialsAccountAndKey(accountName, accountKey);
            CloudStorageAccount cloudStorageAccount = new CloudStorageAccount(storageCredentials, endpoint, null, null, null);
            CloudBlobClient cloudBlobClient = cloudStorageAccount.createCloudBlobClient();
            int serverTimeout = cloudBlobClient.getDefaultRequestOptions().getTimeoutIntervalInMs();
            cloudBlobClient.getDefaultRequestOptions().setTimeoutIntervalInMs(10 * 1000);
            _container = cloudBlobClient.getContainerReference(containerName);
            _container.createIfNotExists();
            cloudBlobClient.getDefaultRequestOptions().setTimeoutIntervalInMs(serverTimeout);
        }
        catch (StorageException e)
        {
            throw new GroupDocsException("Unable to recognize that Account Name/Account Key or container name is invalid." + e.getMessage());
        } catch (URISyntaxException e) {
            throw new GroupDocsException("Unable to recognize that Account Name/Account Key." + e.getMessage());
        }
    }
  
    @Override
    public FileDescription getFileDescription(String guid) {
        try
        {
            String blobName = GetNormalizedBlobName(guid);
            CloudBlob blob = _container.getPageBlobReference(blobName);
//            blob.fetchAttributes();
            final FileDescription fileDescription = new FileDescription(blobName, false);
            fileDescription.setLastModificationDate(getDateTimeOrEmptyDate(blob.getProperties().getLastModified()));
            fileDescription.setSize(blob.getProperties().getLength());
 
            return fileDescription;
        }
        catch (Exception e) {
            throw new GroupDocsException("Unabled to get file description." + e.getMessage());
        }
    }
  
    @Override
    public InputStream getFile(String guid) {
        try
        {
            String blobName = GetNormalizedBlobName(guid);
            CloudBlob blob = _container.getPageBlobReference(blobName);
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            blob.download(arrayOutputStream);
            return new ByteArrayInputStream(arrayOutputStream.toByteArray());
        }
        catch (Exception ex)
        {
            throw new GroupDocsException("Unabled to get file." + ex.getMessage());
        }
    }
 
    @Override
    public Date getLastModificationDate(String guid) {
        FileDescription fileDescription = getFileDescription(guid);
        return fileDescription.getLastModificationDate();
    }
 
    @Override
    public List<FileDescription> loadFileTree(FileTreeOptions fileTreeOptions) {
        try
        {
            String path = GetNormalizedBlobName(fileTreeOptions.getPath());
            List<FileDescription> fileTree = GetFileTree(path);
            return fileTree;
        }
        catch (Exception ex)
        {
            throw new GroupDocsException("Failed to load file tree." + ex.getMessage());
        }
    }
 
    private static URI GetEndpoint(String accountName) throws URISyntaxException {
        String endpoint = EndpointTemplate.replace("{account-name}", accountName);
        return new URI(endpoint);
    }
 
    private List<FileDescription> GetFileTree(String blobName) throws URISyntaxException, StorageException {
        CloudBlobDirectory directory = _container.getDirectoryReference(blobName);
        List<FileDescription> fileTree = new ArrayList<FileDescription>();
        for (ListBlobItem blob : directory.getContainer().listBlobs())
        {
            FileDescription fileDescription;
            CloudBlobDirectory blobDirectory = (CloudBlobDirectory) blob;
            if (blobDirectory != null)
            {
                fileDescription = new FileDescription(blobDirectory.getPrefix(), true);
            }
            else
            {
                CloudBlob blobFile = (CloudBlob) blob;
                fileDescription = new FileDescription(blobFile.getName(), false);
                fileDescription.setSize(blobFile.getProperties().getLength());
                fileDescription.setLastModificationDate(getDateTimeOrEmptyDate(blobFile.getProperties().getLastModified()));
            }
            fileTree.add(fileDescription);
        }
        return fileTree;
    }
 
    private String GetNormalizedBlobName(String guid)
    {
        return guid.replace("\\+", Delimiter);
    }
 
    private Date getDateTimeOrEmptyDate(Date dateTimeOffset)
    {
        Date emptyDate = new Date();
        return dateTimeOffset != null ? dateTimeOffset : emptyDate;
    }

	@Override
	public void saveDocument(CachedDocumentDescription arg0, InputStream arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
//ExEnd: AzureInputDataHandler