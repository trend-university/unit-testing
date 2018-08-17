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

    @Test
    public final void add_whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        StringCalculator.add("1,2,3");
    }

    @Test(expected = RuntimeException.class)
    public final void add_whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }

    @Test
    public final void add_when_null_then_return_0() {
        int ret = StringCalculator.add(null);
        Assert.assertEquals(0, ret);
    }

    @Test
    public final void add_when_Empty_then_return_0() {
        int ret = StringCalculator.add("");
        Assert.assertEquals(0, ret);
    }

    @Test()
    public final void add_2_numbers() {
        int ret = StringCalculator.add("1,2");
        Assert.assertEquals(3, ret);
    }

    @Test()
    public final void add_2_numbers_use_line_breaker() {
        int ret = StringCalculator.add("1\n2");
        Assert.assertEquals(3, ret);
    }

    @Test()
    public final void add_2_numbers_use_comma_and_line_breaker() {
        int ret = StringCalculator.add("1,\n2");
        Assert.assertEquals(3, ret);
    }

    @Test()
    public final void add_3_numbers() {
        int ret = StringCalculator.add("1,2,3");
        Assert.assertEquals(6, ret);
    }

}
