package com.trendmicro.course.unittesting.doubles.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.Test;

public class DemoMock {

  @Test
  public void demo() {
    // mock creation
    @SuppressWarnings("unchecked")
    List<String> mockedList = mock(List.class);

    // using mock object
    // it does not throw any "unexpected interaction" exception
    mockedList.add("one");
    mockedList.clear();

    // selective, explicit, highly readable verification
    verify(mockedList).add("one");
    verify(mockedList).clear();
  }

}
