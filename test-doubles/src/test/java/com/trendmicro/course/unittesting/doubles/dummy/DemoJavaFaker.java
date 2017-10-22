package com.trendmicro.course.unittesting.doubles.dummy;

import com.github.javafaker.Faker;
import org.junit.Test;

/**
 * here the lib names 'javafaker', however it's only for create dummy object, not for create 'fake' object.
 */
public class DemoJavaFaker {

  @Test
  public void demo() {
    Faker faker = new Faker();
    String name = faker.name().fullName();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String streetAddress = faker.address().streetAddress();

    System.out.println("name=" + name);
    System.out.println("firstName=" + firstName);
    System.out.println("lastName=" + lastName);
    System.out.println("streetAddress=" + streetAddress);
  }
}
