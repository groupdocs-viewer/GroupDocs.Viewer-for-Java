package com.viewer.model;

public class GetImageUrlsResponse extends OperationStatusResponse
{
    public String[] imageUrls =  new String[0];
    
    public String[] getImageUrls(){
    	return imageUrls; 
    }
    public void setImageUrls(String[] imageUrls){
    	this.imageUrls = imageUrls;
    }
}