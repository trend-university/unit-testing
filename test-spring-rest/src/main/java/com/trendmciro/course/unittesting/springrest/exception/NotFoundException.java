package com.trendmciro.course.unittesting.springrest.exception;

public class NotFoundException extends CommonException {

  public NotFoundException(int errCode, String errMessage) {
    super(errCode, errMessage);
  }
}
