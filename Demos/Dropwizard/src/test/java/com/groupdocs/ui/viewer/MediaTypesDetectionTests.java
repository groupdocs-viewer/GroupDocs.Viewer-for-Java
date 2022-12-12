package com.groupdocs.ui.viewer;

import com.groupdocs.ui.viewer.dropwizard.common.util.Utils;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

public class MediaTypesDetectionTests {

    @Test
    public void testOtf() {
        final MediaType actualMediaType = Utils.detectMediaType(".otf");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("application/x-font-otf"), actualMediaType);
    }

    @Test
    public void testSfnt() {
        final MediaType actualMediaType = Utils.detectMediaType(".sfnt");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("application/font-sfnt"), actualMediaType);
    }

    @Test
    public void testTtf() {
        final MediaType actualMediaType = Utils.detectMediaType(".ttf");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("application/x-font-ttf"), actualMediaType);
    }

    @Test
    public void testWoff() {
        final MediaType actualMediaType = Utils.detectMediaType(".woff");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("application/x-font-woff"), actualMediaType);
    }

    @Test
    public void testWoff2() {
        final MediaType actualMediaType = Utils.detectMediaType(".woff2");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("application/x-font-woff2"), actualMediaType);
    }

    @Test
    public void testEot() {
        final MediaType actualMediaType = Utils.detectMediaType(".eot");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("application/vnd.ms-fontobject"), actualMediaType);
    }

    @Test
    public void testXml() {
        final MediaType actualMediaType = Utils.detectMediaType(".xml");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("application/xml"), actualMediaType);
    }

    @Test
    public void testSvg() {
        final MediaType actualMediaType = Utils.detectMediaType(".svg");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("image/svg+xml"), actualMediaType);
    }

    @Test
    public void testPng() {
        final MediaType actualMediaType = Utils.detectMediaType(".png");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("image/png"), actualMediaType);
    }

    @Test
    public void testJpg() {
        final MediaType actualMediaType = Utils.detectMediaType(".jpg");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("image/jpeg"), actualMediaType);
    }

    @Test
    public void testHtml() {
        final MediaType actualMediaType = Utils.detectMediaType(".html");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("text/html"), actualMediaType);
    }

    @Test
    public void testJs() {
        final MediaType actualMediaType = Utils.detectMediaType(".js");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("application/javascript"), actualMediaType);
    }

    @Test
    public void testCss() {
        final MediaType actualMediaType = Utils.detectMediaType(".css");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("text/css"), actualMediaType);
    }

    @Test
    public void testGif() {
        final MediaType actualMediaType = Utils.detectMediaType(".gif");
        Assert.assertNotNull(actualMediaType);
        Assert.assertEquals(MediaType.valueOf("image/gif"), actualMediaType);
    }
}
