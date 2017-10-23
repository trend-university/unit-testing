package com.trendmciro.course.unittesting.springrest.controller;

import com.trendmciro.course.unittesting.springrest.exception.ExceptionResponseDTO;
import com.trendmciro.course.unittesting.springrest.exception.NotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler({NotFoundException.class})
  @ResponseBody
  public ExceptionResponseDTO handleNotFound(HttpServletRequest req, NotFoundException ex) {
    return new ExceptionResponseDTO(req.getRequestURL().toString(), HttpStatus.NOT_FOUND.value(), ex);
  }

}
