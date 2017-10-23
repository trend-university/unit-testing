package com.trendmciro.course.unittesting.springrest.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.trendmciro.course.unittesting.springrest.entity.Customer;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDaoTest {

  @Autowired
  private CustomerDao dao;

  @Test
  public void get() throws Exception {
    Customer customer = dao.get(1L);
    assertNotNull(customer);
  }


  @Test
  public void list() throws Exception {
    List<Customer> customers = dao.list();
    assertEquals(3, customers.size());
  }


}
