package com.trendmicro.course.unittesting.practice.advanced;

import java.util.List;

/**
 * indirect input
 */
public interface MessageQueueReceiver {

  List<Message> receive(int maxReceiveCount);

}

