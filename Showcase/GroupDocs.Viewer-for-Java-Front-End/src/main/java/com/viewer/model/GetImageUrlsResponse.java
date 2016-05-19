package com.viewer.model;

public class GetImageUrlsResponse extends OperationStatusResponse
{
    public String[] imageUrls;
    
    public String[] getImageUrls(){
    	return imageUrls; 
    }
    public void setImageUrls(String[] imageUrls){
    	this.imageUrls = imageUrls;
    }
}