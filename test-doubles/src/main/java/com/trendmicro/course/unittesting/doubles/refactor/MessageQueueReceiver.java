package com.trendmicro.course.unittesting.doubles.refactor;

import java.util.List;

/**
 * indirect input
 */
public interface MessageQueueReceiver {

  List<Message> receive(int maxFetchCount);

}
