package com.trendmciro.course.unittesting.springrest.controller;


import com.trendmciro.course.unittesting.springrest.dto.ResponseDTO;
import com.trendmciro.course.unittesting.springrest.entity.Customer;
import com.trendmciro.course.unittesting.springrest.exception.InvalidParameterException;
import com.trendmciro.course.unittesting.springrest.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService service;

  @GetMapping(value = "/{id}")
  public Customer get(
      @PathVariable(value = "id", required = true) Long id) {
    if (id < 0) {
      throw new InvalidParameterException();
    }
    return service.get(id);
  }

  @GetMapping
  public List<Customer> list() {
    return service.list();
  }

  @PostMapping
  public ResponseDTO<Customer> create(
      @RequestBody Customer customer) {
    return service.create(customer);
  }

  @PutMapping(value = "/{id}")
  public ResponseDTO<Customer> update(
      @PathVariable(value = "id", required = true) Long id,
      @RequestBody Customer customer) {
    customer.setId(id);
    return service.update(customer);
  }


}
