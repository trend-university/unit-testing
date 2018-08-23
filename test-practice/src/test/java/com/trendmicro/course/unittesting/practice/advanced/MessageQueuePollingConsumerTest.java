package com.trendmicro.course.unittesting.practice.advanced;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageQueuePollingConsumerTest {

  private static final Logger LOG = LoggerFactory.getLogger(MessageQueuePollingConsumerTest.class);

  @InjectMocks
  private MessageQueuePollingConsumer queueConsumer = new MessageQueuePollingConsumer();

  @Mock
  private MessageQueueReceiver messageReceiver;

  @Mock
  private MessageHandler messageHandler;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void consume_receive_no_message_consume_count_should_return_0() {
    // stub rule not set, mock object has default behavior
    // for List type return, the default behavior is return an empty list

    int consumeCount = queueConsumer.consume();

    Assert.assertEquals(0, consumeCount);
  }

  @Test
  public void consume_receive_one_nonempty_message_should_call_message_handler_once() throws InterruptedException {
    when(messageReceiver.receive(anyInt())).thenReturn(buildMessages(1, "testMessageBody"));

    queueConsumer.consume();
    TimeUnit.SECONDS.sleep(1);

    verify(messageHandler, times(1)).handleMessage(any(Message.class));
  }

  @Test
  public void consume_receive_one_empty_message_should_not_call_message_handler() throws InterruptedException {
    when(messageReceiver.receive(anyInt())).thenReturn(buildMessages(1, ""));

    queueConsumer.consume();
    TimeUnit.SECONDS.sleep(1);

    verify(messageHandler, never()).handleMessage(any(Message.class));
  }

  private List<Message> buildMessages(int count, String messageBody) {
    List<Message> messages = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      messages.add(new Message(String.format("testId-%d", i), messageBody));
    }
    return messages;
  }

}
