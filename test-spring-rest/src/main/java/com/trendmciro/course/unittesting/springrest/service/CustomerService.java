package com.trendmciro.course.unittesting.springrest.service;

import com.trendmciro.course.unittesting.springrest.dao.CustomerDao;
import com.trendmciro.course.unittesting.springrest.dto.ResponseDTO;
import com.trendmciro.course.unittesting.springrest.entity.Customer;
import com.trendmciro.course.unittesting.springrest.exception.NotFoundException;
import com.trendmciro.course.unittesting.springrest.integration.ExternalComponentA;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

  @Autowired
  private CustomerDao dao;

  @Autowired
  private ExternalComponentA componentA;

  public Customer get(Long id) {
    try {
      return dao.get(id);
    } catch (EmptyResultDataAccessException e) {
      throw new NotFoundException(-1, "customer not found by id=" + id);
    }
  }

  public List<Customer> list() {
    return dao.list();
  }

  public ResponseDTO<Customer> create(Customer customer) {
    if (!componentA.validateCustomer(customer)) {
      throw new RuntimeException("validate customer failure");
    }

    Long id = dao.create(customer);
    LOG.info("create customer success, id={}", id);

    Customer customerCreated = dao.get(id);
    ResponseDTO<Customer> dto = new ResponseDTO<>(0, "create customer success", customerCreated);
    return dto;
  }

  public ResponseDTO<Customer> update(Customer customer) {
    Long id = customer.getId();
    int update = dao.update(customer);
    if (update > 0) {
      LOG.info("update customer success, id={}", id);
    } else {
      throw new NotFoundException(0, "customer not found with id=" + id);
    }

    Customer customerUpdated = dao.get(id);
    ResponseDTO<Customer> dto = new ResponseDTO<>(0, "update customer success", customerUpdated);
    return dto;
  }


}
