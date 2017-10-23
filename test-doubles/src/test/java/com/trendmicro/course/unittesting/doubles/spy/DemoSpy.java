package com.trendmicro.course.unittesting.doubles.spy;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class DemoSpy {

  @Test
  public void demo() {
    // mock creation
    List<String> spiedList = spy(new ArrayList<String>());

    // using mock object - it does not throw any "unexpected interaction" exception
    spiedList.add("one");
    spiedList.clear();

    // selective, explicit, highly readable verification
    verify(spiedList).add("one");
    verify(spiedList).clear();
  }
}
