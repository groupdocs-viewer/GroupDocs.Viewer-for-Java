package com.viewer.model;

import java.util.Date;
import java.util.List;


public class FileBrowserTreeNode
{
    public String path;
    public String name;
    public String type;
    public String docType;
    public String fileType;
    public long size;
    public Date modifyTime;
    public List<FileBrowserTreeNode> nodes;
    
    public String getPath(){
    	return path;
    }
    public void setPath(String path){
    	this.path = path;
    }
    
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name  = name;
    }
  
    public String getType(){
    	return type;
    }
    public void setType(String type){
    	this.type = type;
    }
    
    public String getDocType(){
    	return docType;
    }
    public void setDocType(String docType){
    	this.docType = docType;
    }
    
    public String getFileType(){
    	return fileType;
    }
    public void setFileType(String fileType){
    	this.fileType = fileType;
    }
    
    public long getSize(){
    	return size;
    }
    public void setSize(long size){
    	this.size = size;
    }
    
    public Date getModifyTime(){
    	return modifyTime;
    }
    public void setModifyTime(Date modifyTime){
    	this.modifyTime = modifyTime;
    }
    
    public List<FileBrowserTreeNode> getNodes(){
    	return nodes;
    }
    
    public void setNodes(List<FileBrowserTreeNode> nodes){
    	this.nodes = nodes;
    }
    	
}