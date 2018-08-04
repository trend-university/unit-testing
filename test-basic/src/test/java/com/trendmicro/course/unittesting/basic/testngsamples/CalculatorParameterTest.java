package com.trendmicro.course.unittesting.basic.testngsamples;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * demo for parameter test use testng
 */
public class CalculatorParameterTest {

  private CalculatorForTestNg calculator = new CalculatorForTestNg();

  // This method will provide data to any test method that declares that its Data Provider
  // is named "test1"
  @DataProvider(name = "test1")
  public Object[][] createData1() {
    return new Object[][]{
        {"1", 1},
        {"1+2", 3},
        {"1+2+3", 6},

        // below found by pitest
        {"0+1", 0},
        {"1+-2", -1},
    };
  }

  // This test method declares that its data should be supplied by the Data Provider
  // named "test1"
  @Test(dataProvider = "test1")
  public void verifyData1(String expression, Integer result) {
    assertEquals(result, Integer.valueOf(calculator.evaluate(expression)));
  }

}

