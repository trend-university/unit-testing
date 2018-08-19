package com.trendmicro.course.unittesting.doubles.refactor;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class MessageQueuePollingPrinterTest {

  @Test
  public void consume_receive_1_message_should_consume_1() {
    MessageQueueReceiver alwaysOneMessageReceiver = new MessageQueueReceiver() {
      @Override
      public List<Message> receive(int maxFetchCount) {
        return Collections.singletonList(
            new Message("testId-001", "testBody-001"));
      }
    };

    MessageQueuePollingPrinter queuePollingPrinter
        = new MessageQueuePollingPrinter(alwaysOneMessageReceiver);
    int consumeCount = queuePollingPrinter.consume();

    Assert.assertEquals(1, consumeCount);
  }

  @Test
  public void consume_receive_2_message_should_consume_2_use_mock_framework() {
    MessageQueueReceiver alwaysOneMessageReceiver = mock(MessageQueueReceiver.class);
    when(alwaysOneMessageReceiver.receive(anyInt()))
        .thenReturn(Arrays.asList(
            new Message("testId-001", "testBody-001"),
            new Message("testId-002", "testBody-002")));

    MessageQueuePollingPrinter queuePollingPrinter
        = new MessageQueuePollingPrinter(alwaysOneMessageReceiver);
    int consumeCount = queuePollingPrinter.consume();

    Assert.assertEquals(2, consumeCount);
  }
}
