package com.trendmciro.course.unittesting.springrest.service;

import com.trendmciro.course.unittesting.springrest.dao.CustomerDao;
import com.trendmciro.course.unittesting.springrest.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private CustomerDao dao;

  public Customer get(Long id) {
    return dao.get(id);
  }


}
