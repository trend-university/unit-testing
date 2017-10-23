package com.trendmciro.course.unittesting.springrest.exception;

import java.time.LocalDateTime;

public class ExceptionResponseDTO {

  private String path;
  private String timestamp;
  private int status;

  private String exception;
  private int errCode;
  private String errMessage;

  public ExceptionResponseDTO(String path, int status, CommonException ex) {
    this.path = path;
    this.timestamp = LocalDateTime.now().toString();
    this.status = status;
    this.errCode = ex.getErrCode();
    this.errMessage = ex.getErrMessage();
    this.exception = ex.getClass().getName();
  }

  public ExceptionResponseDTO(String path, int status, RuntimeException ex) {
    this.path = path;
    this.timestamp = LocalDateTime.now().toString();
    this.status = status;
    this.errMessage = ex.getMessage();
    this.exception = ex.getClass().getName();
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
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
