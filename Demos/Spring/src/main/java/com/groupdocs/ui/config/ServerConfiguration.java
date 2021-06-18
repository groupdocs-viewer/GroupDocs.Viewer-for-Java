package com.groupdocs.ui.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ServerConfiguration.class);

    private Integer httpPort;
    @Value("#{servletContext.contextPath}")
    private String applicationContextPath;

    public Integer getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }

    public String getApplicationContextPath() {
        return applicationContextPath;
    }

    public void setApplicationContextPath(String applicationContextPath) {
        this.applicationContextPath = applicationContextPath;
    }

    @Override
    public String toString() {
        return "ServerConfiguration{" +
                "httpPort=" + httpPort +
                ", applicationContextPath='" + applicationContextPath + '\'' +
                '}';
    }
}
