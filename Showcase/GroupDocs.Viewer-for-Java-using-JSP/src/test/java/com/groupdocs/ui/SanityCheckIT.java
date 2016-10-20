package com.groupdocs.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SanityCheckIT {

    @Test
    public void checkTitle() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/");
        Assert.assertEquals("GroupDocs.Viewer for Java", driver.getTitle());
    }

}

