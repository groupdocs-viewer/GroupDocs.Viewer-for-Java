package com.groupdocs.viewer.ui;

import com.groupdocs.viewer.domain.html.PageHtml;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("canvas")
@ViewScoped
public class Canvas implements Serializable {

    @Inject
    private Document document;

    @Inject
    private Pager pager;

    public String getContent() {
        PageHtml h = document.getPageHtml();
        if (h != null) {
            return h.getHtmlContent();
        }
        return "No contents for page: " + pager.getCurrent();
    }
}

