package com.groupdocs.ui.viewer;

import com.groupdocs.ui.viewer.spring.resources.ViewerResources;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourcesTest {

    MockMvc mvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    ViewerResources controller;

    @Before
    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        this.mvc = standaloneSetup(this.controller).setViewResolvers(viewResolver).build();
    }

    @Test
    public void getView() throws Exception {
        mvc.perform(get("/viewer")).andExpect(status().isOk()).andExpect(view().name("viewer"));
    }

    void loadFileTree() {
    }

    void loadDocumentDescription() {
    }

    void loadDocumentPage() {
    }

    void rotateDocumentPages() {
    }

    void downloadDocument() {
    }

    void uploadDocument() {
    }
}