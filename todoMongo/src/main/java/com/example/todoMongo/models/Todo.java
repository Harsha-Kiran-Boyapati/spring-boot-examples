package com.example.todoMongo.models;

import jakarta.annotation.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@Document(collation = "todos")
public class Todo {
    @Id
    Integer id;
    String description;
    boolean completed;

    public Todo(String description, boolean completed) {
        this.description = description; this.completed = completed;
    }
}
