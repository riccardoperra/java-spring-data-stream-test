package com.riccardoperra.aggregator.service;

import java.time.Duration;
import java.util.function.Function;
import java.util.logging.Level;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoHandler {
  @Bean
  public Function<Flux<Message<Object>>, Flux<Message<Object>>> todoAggregator() {
    return (message) -> {
      log.info("aggregating objects");
      return message
              .delayElements(Duration.ofSeconds(2))
              .log("aggregating object message", Level.INFO);
    };
  }
}
