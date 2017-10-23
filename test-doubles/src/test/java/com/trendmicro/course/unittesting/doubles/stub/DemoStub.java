package com.trendmicro.course.unittesting.doubles.stub;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import org.junit.Test;

public class DemoStub {


  @Test
  public void demo() {
    // you can mock concrete classes, not only interfaces
    LinkedList mockedList = mock(LinkedList.class);

    // stubbing appears before the actual execution
    when(mockedList.get(0)).thenReturn("first");

    // the following prints "first"
    System.out.println(mockedList.get(0));

    // the following prints "null" because get(999) was not stubbed
    System.out.println(mockedList.get(999));
  }


}
