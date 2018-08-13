package com.trendmicro.course.unittesting.practice;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {


  @Test(expected = RuntimeException.class)
  public final void add_whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
    StringCalculator.add("1,2,3");
  }

  @Test
  public final void add_when2NumbersAreUsedThenNoExceptionIsThrown() {
    StringCalculator.add("1,2");
    Assert.assertTrue(true);
  }

  @Test(expected = RuntimeException.class)
  public final void add_whenNonNumberIsUsedThenExceptionIsThrown() {
    StringCalculator.add("1,X");
  }


}
