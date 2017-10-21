package com.trendmicro.course.unittesting.basic.testngsamples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {

  @BeforeClass
  public void setUp() {
    System.out.println("SimpleTest setUp");
  }

  @Test
  public void aTest() {
    System.out.println("a test");
  }

  @Test(groups = {"fast"})
  public void aFastTest() {
    System.out.println("Fast test");
  }

  @Test(groups = {"slow"})
  public void aSlowTest() {
    System.out.println("Slow test");
  }

}
