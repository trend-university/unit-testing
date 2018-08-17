package com.trendmicro.course.unittesting.practice.advanced;

/**
 * indirect output
 */
@FunctionalInterface
public interface MessageHandler {

  void handleMessage(Message message);

}
