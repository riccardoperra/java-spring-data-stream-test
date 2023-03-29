package com.riccardoperra.reader.service;

import com.riccardoperra.reader.entity.Todo;
import com.riccardoperra.reader.repository.TodoReactiveRepository;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoHandler {
  private final TodoReactiveRepository repository;

  @Autowired ReactiveMongoTemplate template;

  @Bean
  @PollableBean
  public Supplier<Flux<Message<Todo>>> todoReaderProducer() {
    return () -> {
      log.info("Reading producer todoReaderProducer");
      return repository.findAll().map(el -> MessageBuilder.withPayload(el).build());
    };
  }
}
