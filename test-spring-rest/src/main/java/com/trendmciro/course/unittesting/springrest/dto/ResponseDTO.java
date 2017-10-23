package com.trendmciro.course.unittesting.springrest.dto;

import java.time.LocalDateTime;

public class ResponseDTO<T> {

  private String timestamp;
  private int status;
  private String message;
  private T data;

  public ResponseDTO(int status, String message, T data) {
    this.timestamp = LocalDateTime.now().toString();
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}

