package com.example.todoJpa.controllers;

import com.example.todoJpa.dtos.CreateTodoDto;
import com.example.todoJpa.repositories.TodoRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
public class TodoControllerWebMvcTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ApplicationContext context;
    @MockBean private TodoRepository todoRepository;

    @Test
    public void contextLoads(){
        Assertions.assertNotNull(context);
    }

    @Test
    public void inspectApplicationContext(){
        DispatcherServlet dispatcherServlet = context.getBean(DispatcherServlet.class);
        String[] beanNames = context.getBeanDefinitionNames();
        int beanCount = context.getBeanDefinitionCount();
        MockMvc mockMvcBean = context.getBean(MockMvc.class);
//        assertEquals(dispatcherServlet.getSer)
    }

    @Test
    public void getTodos() throws Exception{
        this.mockMvc.perform(get("/todos")).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void postTodos() throws Exception {
        String body = new JSONObject(Map.of("description", "hi", "completed", false)).toString();
        this.mockMvc.perform(
                post("/todos").contentType("application/json")
                        .content(body)
        ).
                andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void differentWaysToCreateJsonString() throws Exception {
        CreateTodoDto todo1  = new CreateTodoDto("write tests", false);
        System.out.println(todo1.toString());
        JSONObject jsonTodo1 = new JSONObject();
        jsonTodo1.put("description", "hello");
        jsonTodo1.put("completed", false);
        System.out.println(jsonTodo1.toString());

        JSONObject jsonTodo2 = new JSONObject(Map.of("description", "hi", "completed", false));
        System.out.println(jsonTodo2.toString());

    }
}
