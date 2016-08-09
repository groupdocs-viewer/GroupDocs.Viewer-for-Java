package com.viewer.model;

import java.util.ArrayList;

public class FileBrowserTreeDataResponse
{
    public ArrayList< FileBrowserTreeNode> nodes;
    public int count;
    
    public ArrayList<FileBrowserTreeNode> getNodes(){
    	return nodes;
    }
    public void setNodes(ArrayList<FileBrowserTreeNode> arrayList){
    	this.nodes = arrayList;
    }
    public int getCount(){
    	return count;
    }
    public void setCount(int count){
    	this.count = count;
    }
}