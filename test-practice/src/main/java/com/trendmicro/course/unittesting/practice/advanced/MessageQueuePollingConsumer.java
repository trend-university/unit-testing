package com.trendmicro.course.unittesting.practice.advanced;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageQueuePollingConsumer {

  private static final Logger LOG = LoggerFactory.getLogger(MessageQueuePollingConsumer.class);
  private static int EXECUTE_POOL_SIZE = 10;

  private final ThreadPoolExecutor executor;
  private MessageQueueReceiver messageReceiver;
  private MessageHandler messageHandler;

  public MessageQueuePollingConsumer(MessageQueueReceiver messageReceiver, MessageHandler messageHandler) {
    this.messageReceiver = messageReceiver;
    this.messageHandler = messageHandler;
    this.executor = new ThreadPoolExecutor(
        EXECUTE_POOL_SIZE, EXECUTE_POOL_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  }

  public int consume() {
    int maxPoolSize = executor.getMaximumPoolSize();
    int activeCount = executor.getActiveCount();
    if (activeCount >= maxPoolSize) {
      LOG.warn("foundNoIdleThread for execute, activeCount={}, maxPoolSize={}",
          activeCount, maxPoolSize);
      return 0;
    }

    int tryCount = maxPoolSize - activeCount;
    LOG.info("foundIdleThread for execute, tryCount={}", tryCount);

    List<Message> messages = receiveMessages(tryCount);
    int consumedCount = messages.size();
    if (consumedCount > 0) {
      LOG.info("consumeMessagesSuccess, tryCount={}, consumedCount={}",
          tryCount, consumedCount);
      messages.forEach(message -> executeMessage(message));
    }
    return consumedCount;
  }

  private List<Message> receiveMessages(int tryConsumeCount) {
    return messageReceiver.receive(tryConsumeCount);
  }

  private void executeMessage(Message message) {
    LOG.debug("executeMessage Start, messageId={}", message.getMessageId());
    executor.execute(() -> handleMessage(message));
    LOG.debug("executeMessage Submitted, messageId={}", message.getMessageId());
  }

  private void handleMessage(Message message) {
    messageHandler.handleMessage(message);
  }

}