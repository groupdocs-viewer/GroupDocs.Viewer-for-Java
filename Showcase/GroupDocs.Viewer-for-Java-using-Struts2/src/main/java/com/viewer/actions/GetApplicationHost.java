package com.viewer.actions;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GetApplicationHost {

    private InputStream result;

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String h = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

        this.result = new ByteArrayInputStream(h.getBytes());
        return "success";
    }

    public InputStream getResult() {
        return result;
    }
}

