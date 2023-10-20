package com.example.todoMongo.repositories;

import com.example.todoMongo.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, Integer> {
}
