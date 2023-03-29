package com.riccardoperra.reader.controller;

import com.riccardoperra.reader.entity.Todo;
import com.riccardoperra.reader.repository.TodoReactiveRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
  private final TodoReactiveRepository todoReactiveRepository;

  @GetMapping
  public List<Todo> getTodos() {
    return todoReactiveRepository.findAll().collectList().block();
  }

  @PostMapping
  public Todo createTodos() {
    return todoReactiveRepository
        .save(Todo.builder().id(UUID.randomUUID()).title("test").completed(false).build())
        .block();
  }
}
