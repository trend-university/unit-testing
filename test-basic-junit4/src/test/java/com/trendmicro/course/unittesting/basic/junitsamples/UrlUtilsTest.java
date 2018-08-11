package com.trendmicro.course.unittesting.basic.junitsamples;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UrlUtilsTest {

  @Test
  public void isRootUrl() {
    /*
     * without protocol prefix
     */
    assertTrue(UrlUtils.isRootUrl("dmarket.sharepoint.com"));
    assertTrue(UrlUtils.isRootUrl("dmarket.sharepoint.com/"));

    assertFalse(UrlUtils.isRootUrl("dmarket.sharepoint.com/A"));
    assertFalse(UrlUtils.isRootUrl("dmarket.sharepoint.com/A/"));

    /*
     * with protocol prefix
     */
//    assertTrue(UrlUtils.isRootUrl("https://dmarket.sharepoint.com"));
//    assertTrue(UrlUtils.isRootUrl("https://dmarket.sharepoint.com/"));
//
//    assertFalse(UrlUtils.isRootUrl("https://dmarket.sharepoint.com/A"));
//    assertFalse(UrlUtils.isRootUrl("https://dmarket.sharepoint.com/A/"));
//
//    assertFalse(UrlUtils
//        .isRootUrl("https://dmarket.sharepoint.com/sites/collectionA"));
//    assertFalse(UrlUtils
//        .isRootUrl("https://dmarket.sharepoint.com/sites/siteA"));
//    assertFalse(UrlUtils
//        .isRootUrl("https://dmarket.sharepoint.com/sites/collectionA/siteA"));

  }
}
