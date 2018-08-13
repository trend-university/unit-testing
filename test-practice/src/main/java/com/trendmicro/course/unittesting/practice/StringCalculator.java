package com.trendmicro.course.unittesting.practice;

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
public class StringCalculator {

  /**
   * initial status: Requirement 1 done
   */
  public static int add(String numbers) {
    String[] numbersArray = numbers.split(",");
    if (numbersArray.length > 2) {
      throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
    } else {
      for (String number : numbersArray) {
        Integer.parseInt(number); // If it is not a number, parseInt will throw an exception
      }
    }
    return 0;
  }

}
