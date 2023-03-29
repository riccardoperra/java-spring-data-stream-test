package com.riccardoperra.reader.repository;

import com.riccardoperra.reader.entity.Todo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface TodoReactiveRepository extends ReactiveMongoRepository<Todo, UUID> {
}
