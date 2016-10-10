package com.viewer.model;
public class RotatePageParameters
{
    public String path; 
    public int pageNumber;
    public int rotationAmount;
    public String instanceIdToken;
    public String callBack;
    //
    public String getPath(){
    	return path;
    }
    public void setPath(String path){
    	 this.path = path;
    }
    //
    public int getPageNumber(){
    	return pageNumber;
    }
    public void setPageNumber(int pageNumber){
    	 this.pageNumber = pageNumber;
    }
    //
    public int getRotationAmount(){
    	return rotationAmount;
    }
    public void setRotationAmount(int rotationAmount){
    	 this.rotationAmount = rotationAmount;
    }
    //
    public String getInstanceIdToken(){
    	return instanceIdToken;
    }
    public void setInstanceIdToken(String instanceIdToken){
    	 this.instanceIdToken = instanceIdToken;
    }
    //
    public String getCallBack(){
    	return callBack;
    }
    public void setCallBack(String callBack){
    	 this.callBack = callBack;
    }
    
}

/*class RotatePageResponse
{
    public RotatePageResponse()
    {
        success = true;
    }

    public bool success;
    public int resultAngle;
}*/