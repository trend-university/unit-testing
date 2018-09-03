package com.trendmicro.course.unittesting.practice.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 * Create a simple String calculator with a method int add(string numbers)
 *  - Requirement 1: The method can take 0, 1 or 2 numbers separated by comma (,).
 *  - Requirement 2: For an empty string the method will return 0
 *  - Requirement 3: Method will return their sum of numbers
 *  - Requirement 4: Allow the Add method to handle an unknown amount of numbers
 *  - Requirement 5: Allow the Add method to handle new lines between numbers (instead of commas).
 *    - the following input is ok:  “1\n2,3”  (will equal 6)
 *    - the following input is NOT ok:  “1,\n” (not need to prove it - just clarifying)
 * </pre>
 */
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
