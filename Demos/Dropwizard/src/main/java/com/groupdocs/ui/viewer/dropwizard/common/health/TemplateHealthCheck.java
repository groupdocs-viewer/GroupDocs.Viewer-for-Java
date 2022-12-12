package com.groupdocs.ui.viewer.dropwizard.common.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Dummy HealthCheck
 *
 * @author Aspose Pty Ltd
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() {
        return Result.healthy();
    }

}
