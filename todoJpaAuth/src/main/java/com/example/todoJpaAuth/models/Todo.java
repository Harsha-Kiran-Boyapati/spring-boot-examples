package com.example.todoJpaAuth.models;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String description;
    private boolean completed;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

}
