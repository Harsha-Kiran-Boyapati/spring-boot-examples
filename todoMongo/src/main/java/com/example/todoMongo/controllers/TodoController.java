package com.example.todoMongo.controllers;

import com.example.todoMongo.dtos.CreateTodoDto;
import com.example.todoMongo.models.Todo;
import com.example.todoMongo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value = "/todos/{id}", produces = "application/json")
    public ResponseEntity<Todo> getTodo(@PathVariable int id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        return ResponseEntity.of(optionalTodo);
    }

    @GetMapping(value = "/todos", produces = "application/json")
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    @PostMapping(value = "/todos", produces = "application/json", consumes = "application/json")
    public Todo createTodo(@RequestBody CreateTodoDto todoDto){
        Todo todo = todoRepository.save(new Todo(todoDto.description, todoDto.completed));
        return todo;
    }

    @PutMapping(value = "/todos/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity updateTodo(@PathVariable(required = true) int id, @RequestBody CreateTodoDto todoDto){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            optionalTodo.get().setDescription(todoDto.description);
            optionalTodo.get().setCompleted(todoDto.completed);
            todoRepository.save(optionalTodo.get());
        }
        return ResponseEntity.of(optionalTodo);
    }

    @DeleteMapping(value = "/todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable(required = true) int id, @RequestBody CreateTodoDto todoDto){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            todoRepository.delete(optionalTodo.get());
            return new ResponseEntity(HttpStatus.OK);
        } else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
