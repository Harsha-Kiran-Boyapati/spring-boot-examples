package com.example.todoJpa.dtos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTodoDto {
    public String description = "";
    public boolean completed = false;
}
