package com.trendmciro.course.unittesting.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "invalid input parameter")
public class InvalidParameterException extends RuntimeException {

}
