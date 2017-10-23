package com.trendmciro.course.unittesting.springrest.dao;


import com.trendmciro.course.unittesting.springrest.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Customer get(Long id) {
    return new Customer("chad", "chen");
  }

}
