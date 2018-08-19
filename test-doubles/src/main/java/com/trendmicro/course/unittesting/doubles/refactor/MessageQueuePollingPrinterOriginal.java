package com.trendmicro.course.unittesting.doubles.refactor;

import java.util.List;

public class MessageQueuePollingPrinterOriginal {

  private static int CONSUME_COUNT = 10;

  public int consume() {
    int tryCount = CONSUME_COUNT;
    List<Message> messages = receiveMessages(tryCount);
    messages.forEach(this::printMessage);
    return messages.size();
  }

  private List<Message> receiveMessages(int tryConsumeCount) {
    // TODO: consumeMessages from external queue system
    return null;
  }

  private void printMessage(Message message) {
    System.out.println("messageId=" + message.getMessageId());
  }

}
