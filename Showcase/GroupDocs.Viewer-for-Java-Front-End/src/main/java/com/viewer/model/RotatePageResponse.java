package com.viewer.model; 
public class RotatePageResponse
    {
        public RotatePageResponse()
        {
            success = true;
        }

        public Boolean success;
        public int resultAngle;
        //
        public Boolean getSuccess(){
        	return success;
        }
        public void setSuccess(Boolean success){
        	this.success = success;
        }
        //
        public int getResultAngle(){
        	return resultAngle;
        }
        public void setResultAngle(int resultAngle){
        	this.resultAngle = resultAngle;
        }
    }