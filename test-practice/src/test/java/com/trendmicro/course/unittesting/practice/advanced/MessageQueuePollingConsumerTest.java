package com.trendmicro.course.unittesting.practice.advanced;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
  public void consume_receive_one_nonempty_message_should_call_message_handler_once() {

  }

  @Test
  public void consume_receive_eleven_nonempty_messages_consume_count_should_return_ten() {

  }

  @Test
  public void consume_receive_one_empty_message_should_not_call_message_handler() {

  }

}
