package com.trendmciro.course.unittesting.springrest.exception;

public class CommonException extends RuntimeException {

  private int errCode;
  private String errMessage;

  public CommonException(int errCode, String errMessage) {
    super(errMessage);
    this.errCode = errCode;
    this.errMessage = errMessage;
  }

  public int getErrCode() {
    return errCode;
  }

  public void setErrCode(int errCode) {
    this.errCode = errCode;
  }

  public String getErrMessage() {
    return errMessage;
  }

  public void setErrMessage(String errMessage) {
    this.errMessage = errMessage;
  }

}
