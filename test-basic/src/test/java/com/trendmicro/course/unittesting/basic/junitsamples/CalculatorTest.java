package com.trendmicro.course.unittesting.basic.junitsamples;

import static org.junit.Assert.*;

import com.trendmicro.course.unittesting.basic.junitsamples.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void evaluate() throws Exception {
    Calculator calculator = new Calculator();
    int sum = calculator.evaluate("1+2+3");
    assertEquals(6, sum);
  }

}