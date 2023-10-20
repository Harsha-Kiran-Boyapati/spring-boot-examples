package com.example.todoJpa.repositories;

import com.example.todoJpa.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
