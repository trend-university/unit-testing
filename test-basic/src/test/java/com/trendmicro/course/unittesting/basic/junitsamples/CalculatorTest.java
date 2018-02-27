package com.trendmicro.course.unittesting.basic.junitsamples;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void evaluate() {
    Calculator calculator = new Calculator();
    int sum = calculator.evaluate("1+2+3");
    assertEquals(6, sum);
  }

}