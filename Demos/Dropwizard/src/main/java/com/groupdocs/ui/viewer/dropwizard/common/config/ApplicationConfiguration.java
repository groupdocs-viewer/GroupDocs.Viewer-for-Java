package com.groupdocs.ui.viewer.dropwizard.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

import static com.groupdocs.ui.viewer.dropwizard.common.config.DefaultDirectories.*;

/**
 * ApplicationConfiguration
 *
 * @author Aspose Pty Ltd
 */
public class ApplicationConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private String licensePath;
    @Valid
    @JsonProperty
    private String hostAddress;

    public String getLicensePath() {
        return licensePath == null || StringUtils.isBlank(licensePath) ? LICENSES : licensePath;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }
}
