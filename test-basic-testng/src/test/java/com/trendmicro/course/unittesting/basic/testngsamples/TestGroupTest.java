package com.trendmicro.course.unittesting.basic.testngsamples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * demo how to group test cases by testng.
 * refer gradle test task for how to execute test cases by test group names.
 */
public class TestGroupTest {

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
