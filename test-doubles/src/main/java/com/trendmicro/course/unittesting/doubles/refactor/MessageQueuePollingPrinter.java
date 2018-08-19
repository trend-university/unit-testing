package com.trendmicro.course.unittesting.doubles.refactor;

import java.util.List;

public class MessageQueuePollingPrinter {

  private static int CONSUME_COUNT = 10;

  private final MessageQueueReceiver queueReceiver;

  public MessageQueuePollingPrinter(MessageQueueReceiver queueReceiver) {
    this.queueReceiver = queueReceiver;
  }

  public MessageQueueReceiver getQueueReceiver() {
    return queueReceiver;
  }

  public int consume() {
    int tryCount = CONSUME_COUNT;
    List<Message> messages = receiveMessages(tryCount);
    messages.forEach(this::printMessage);
    return messages.size();
  }

  private List<Message> receiveMessages(int tryReceiveCount) {
    return queueReceiver.receive(tryReceiveCount);
  }

  private void printMessage(Message message) {
    System.out.println("messageId=" + message.getMessageId());
  }
}
