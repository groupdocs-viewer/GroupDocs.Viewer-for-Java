package com.groupdocs.ui.viewer.dropwizard.common.config;

import io.dropwizard.Configuration;

/**
 * ServerConfiguration
 *
 * @author Aspose Pty Ltd
 */
public class ServerConfiguration extends Configuration {
    private int httpPort;

    public int getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(int httpPort) {
        this.httpPort = httpPort;
    }

}
