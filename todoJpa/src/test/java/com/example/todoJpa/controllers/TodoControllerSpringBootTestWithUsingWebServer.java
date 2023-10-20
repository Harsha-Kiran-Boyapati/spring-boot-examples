package com.example.todoJpa.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerSpringBootTestWithUsingWebServer {
    @Autowired
    private ApplicationContext context;
    @Autowired private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads(){
        Assertions.assertNotNull(context);
    }

    @Test
    public void inspectApplicationContext(){
        DispatcherServlet dispatcherServlet = context.getBean(DispatcherServlet.class);
        String[] beanNames = context.getBeanDefinitionNames();
        int beanCount = context.getBeanDefinitionCount();
    }
}
