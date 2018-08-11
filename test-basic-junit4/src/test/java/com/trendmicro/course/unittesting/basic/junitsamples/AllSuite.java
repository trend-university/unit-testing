package com.trendmicro.course.unittesting.basic.junitsamples;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * demo junit test suite.
 * not a flexible test cases structure method, really not recommended.
 */
@RunWith(Suite.class)
@SuiteClasses({
    AdderTest.class,
    CalculatorTest.class
})
public class AllSuite {

}
