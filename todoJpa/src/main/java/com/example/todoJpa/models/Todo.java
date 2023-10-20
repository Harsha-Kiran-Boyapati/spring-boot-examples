package com.example.todoJpa.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String description;
    boolean completed;

//    public Todo(int id, String description, boolean completed) {
//        this.id = id;
//        this.description = description;
//        this.completed = completed;
//    }

    public Todo(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }
}

