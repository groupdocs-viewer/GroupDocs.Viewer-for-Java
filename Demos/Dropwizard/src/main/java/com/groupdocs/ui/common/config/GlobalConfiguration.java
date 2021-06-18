package com.groupdocs.ui.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.viewer.config.ViewerConfiguration;
import io.dropwizard.Configuration;

import javax.validation.Valid;

/**
 * GlobalConfiguration
 * Object to hold all application's configurations from yml file
 *
 * @author Aspose Pty Ltd
 */
public class GlobalConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private ServerConfiguration server;

    @Valid
    @JsonProperty
    private ApplicationConfiguration application;

    @Valid
    @JsonProperty
    private CommonConfiguration common;

    @Valid
    @JsonProperty
    private ViewerConfiguration viewer;

    /**
     * Constructor
     */
    public GlobalConfiguration(){
        server = new ServerConfiguration();
        application = new ApplicationConfiguration();
        common = new CommonConfiguration();
        viewer = new ViewerConfiguration();
    }

    /**
     * Get server configuration
     * @return server configuration
     */
    public ServerConfiguration getServer() {
        return server;
    }

    /**
     * Get application configuration
     * @return application configuration
     */
    public ApplicationConfiguration getApplication() {
        return application;
    }

    /**
     * Get common configuration
     * @return common configuration
     */
    public CommonConfiguration getCommon() {
        return common;
    }

    /**
     * Get viewer configuration
     * @return viewer configuration
     */
    public ViewerConfiguration getViewer() {
        return viewer;
    }

}


