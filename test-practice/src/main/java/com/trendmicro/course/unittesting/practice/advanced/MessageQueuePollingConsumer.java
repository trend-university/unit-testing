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

  public MessageQueuePollingConsumer() {
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

    int tryConsumeCount = maxPoolSize - activeCount;
    LOG.info("foundIdleThread for execute, tryConsumeCount={}", tryConsumeCount);

    List<Message> messages = receiveMessages(tryConsumeCount);
    int consumedCount = messages.size();
    if (consumedCount > 0) {
      LOG.info("consumeMessagesSuccess, tryConsumeCount={}, consumedCount={}",
          tryConsumeCount, consumedCount);
      messages.forEach(this::executeMessage);
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
    String messageId = message.getMessageId();
    String messageBody = message.getMessageBody();

    LOG.debug("handleMessage Start, messageId={}", messageId);
    if (messageBody == null || messageBody.isEmpty()) {
      LOG.warn("handleMessage Skipped, due messageBody is null or empty");
      return;
    }

    messageHandler.handleMessage(message);
    LOG.debug("handleMessage Done, messageId={}", messageId);
  }

  public MessageQueueReceiver getMessageReceiver() {
    return messageReceiver;
  }

  public void setMessageReceiver(MessageQueueReceiver messageReceiver) {
    this.messageReceiver = messageReceiver;
  }

  public MessageHandler getMessageHandler() {
    return messageHandler;
  }

  public void setMessageHandler(MessageHandler messageHandler) {
    this.messageHandler = messageHandler;
  }
}
