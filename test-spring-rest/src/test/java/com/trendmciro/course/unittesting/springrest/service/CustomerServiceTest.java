package com.trendmciro.course.unittesting.springrest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.trendmciro.course.unittesting.springrest.dao.CustomerDao;
import com.trendmciro.course.unittesting.springrest.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerServiceTest {

  @InjectMocks
  private CustomerService service = new CustomerService();

  @Mock
  private CustomerDao dao;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void get() throws Exception {

    when(dao.get(1L)).thenReturn(new Customer("chad", "chen"));
    Customer customer = service.get(1L);

    assertEquals("chad", customer.getFirstName());
    assertEquals("chen", customer.getLastName());

  }

}