package com.trendmciro.course.unittesting.springrest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.trendmciro.course.unittesting.springrest.dao.CustomerDao;
import com.trendmciro.course.unittesting.springrest.dto.ResponseDTO;
import com.trendmciro.course.unittesting.springrest.entity.Customer;
import com.trendmciro.course.unittesting.springrest.integration.ExternalComponentA;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerServiceTest {

  private static Customer CUSTOMER_1 = new Customer("jimmy", "zhou");

  @InjectMocks
  private CustomerService service = new CustomerService();

  @Mock
  private CustomerDao dao;

  @Mock
  private ExternalComponentA componentA;

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

  @Test
  public void create_success() throws Exception {
    when(componentA.validateCustomer(any())).thenReturn(true);

    ResponseDTO<Customer> dto = service.create(CUSTOMER_1);

    assertEquals(0, dto.getStatus());
  }

  @Test(expected = RuntimeException.class)
  public void create_customer_not_valid() throws Exception {
    when(componentA.validateCustomer(any())).thenReturn(false);

    service.create(CUSTOMER_1);
  }
}
