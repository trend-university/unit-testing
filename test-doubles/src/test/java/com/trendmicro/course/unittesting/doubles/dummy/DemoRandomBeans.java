package com.trendmicro.course.unittesting.doubles.dummy;

import static java.nio.charset.Charset.forName;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trendmicro.course.unittesting.doubles.entities.Street;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Test;

public class DemoRandomBeans {

  private static EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
      .seed(123L)
      .objectPoolSize(100)
      .randomizationDepth(3)
      .charset(forName("UTF-8"))
      .stringLengthRange(5, 50)
      .collectionSizeRange(1, 10)
      .scanClasspathForConcreteTypes(true)
      .overrideDefaultInitialization(false)
      .build();

  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Test
  public void demo() {

    Street street = random.nextObject(Street.class);
    System.out.println("street: \n" + gson.toJson(street));

  }


}
