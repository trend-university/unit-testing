package com.trendmciro.course.unittesting.springrest.controller;


import com.trendmciro.course.unittesting.springrest.entity.Customer;
import com.trendmciro.course.unittesting.springrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService service;

  @GetMapping(value = "/{id}")
  public Customer get(@PathVariable(value = "id", required = true) Long id) {
    return service.get(id);
  }


}
