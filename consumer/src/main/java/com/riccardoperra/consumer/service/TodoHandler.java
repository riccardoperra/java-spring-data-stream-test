package com.riccardoperra.consumer.service;

import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoHandler {
  @Bean
  public Consumer<Message<Object>> todoReaderConsumer() {
    return (message) -> {
      log.info("consuming object - {}", message.getPayload());
    };
  }
}
