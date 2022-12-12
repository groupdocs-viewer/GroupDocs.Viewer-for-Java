package com.groupdocs.ui.viewer.dropwizard.views;

import com.groupdocs.ui.viewer.dropwizard.common.config.GlobalConfiguration;
import io.dropwizard.views.View;

import java.nio.charset.Charset;

/**
 * Viewer View
 *
 * @author Aspose Pty Ltd
 */

public class Viewer extends View {
    private GlobalConfiguration globalConfiguration;

    /**
     * Constructor
     *
     * @param globalConfiguration total configuration
     * @param charset             charset
     */
    public Viewer(GlobalConfiguration globalConfiguration, String charset) {
        super("viewer.ftl", Charset.forName(charset));
        this.globalConfiguration = globalConfiguration;
    }

    /**
     * Get total config
     *
     * @return total config
     */
    public GlobalConfiguration getGlobalConfiguration() {
        return globalConfiguration;
    }

    /**
     * Set total config
     *
     * @param globalConfiguration total config
     */
    public void setGlobalConfiguration(GlobalConfiguration globalConfiguration) {
        this.globalConfiguration = globalConfiguration;
    }

}
