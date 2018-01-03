package com.groupdocs.viewer.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.net.ftp.*;

import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.domain.cache.CachedDocumentDescription;
import com.groupdocs.viewer.domain.options.FileListOptions;
import com.groupdocs.viewer.handler.input.IInputDataHandler;

//ExStart: FTPInputDataHandler
public class FTPInputDataHandler implements IInputDataHandler {
	 
    private final String _server = "ftp://localhost";
    private final String _userName = "anonymous";
    private final String _userPassword = "";
 
    @Override
    public FileDescription getFileDescription(String guid) {
        return new FileDescription(guid);
    }
 
    @Override
    public InputStream getFile(String guid) {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(_server);
            ftpClient.login(_userName, _userPassword);
            ftpClient.retrieveFile(guid, arrayOutputStream);
            ftpClient.disconnect();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(arrayOutputStream.toByteArray());
    }
 
    @Override
    public Date getLastModificationDate(String guid) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(_server);
            ftpClient.login(_userName, _userPassword);
            FTPFile[] files = ftpClient.listFiles(guid);
            if (files.length > 0) {
                final FTPFile ftpFile = files[0];
                FileDescription fileDescription = new FileDescription(ftpFile.getName(), ftpFile.getName(), ftpFile.isDirectory());
                return fileDescription.getLastModificationDate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
 
    
    public List<FileDescription> loadFileTree(FileListOptions fileTreeOptions) {
        List<FileDescription> fileDescriptions = new ArrayList<FileDescription>();
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(_server);
            ftpClient.login(_userName, _userPassword);
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile ftpFile : files) {
                FileDescription fileDescription = new FileDescription(ftpFile.getName(), ftpFile.getName(), ftpFile.isDirectory());
                fileDescriptions.add(fileDescription);
            }
            ftpClient.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileDescriptions;
    }

	public void saveDocument(CachedDocumentDescription arg0, InputStream arg1) {
		// TODO Auto-generated method stub
		
	}

	public void addFile(String arg0, InputStream arg1) {
		// TODO Auto-generated method stub
		
	}

	public List<FileDescription> getEntities(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
//ExEnd: FTPInputDataHandler