package com.groupdocs.viewer.ui;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("pager")
@ViewScoped
public class Pager implements Serializable {
    private int current = 1;

    @Inject
    private Document document;

    public int getCurrent() {
        return current;
    }

    public void next() {
        current++;
    }

    public void first() {
        current = 1;
    }

    public void last() {
        current = document.getPageCount();
    }

    public void previous() {
        current--;
    }

    public boolean hasPrevious() {
        return current > 1;
    }

    public boolean hasNext() {
        return current < document.getPageCount();
    }
}

