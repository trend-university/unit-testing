package com.trendmicro.course.unittesting.basic.junitsamples;

public class UrlUtils {

  public static boolean isRootUrl(String url) {
    int doubleslash = url.indexOf("//");
    if (doubleslash == -1) {
      doubleslash = 0;
    } else {
      doubleslash += 2;
    }

    int end = url.indexOf('/', doubleslash);
    if (end == -1 || end == url.length() - 1) {
      return true;
    }
    return false;
  }

}

