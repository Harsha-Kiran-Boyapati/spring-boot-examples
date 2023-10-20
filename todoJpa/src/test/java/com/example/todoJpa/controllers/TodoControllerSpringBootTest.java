package com.example.todoJpa.controllers;

import com.example.todoJpa.repositories.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerSpringBootTest {
    @Autowired private ApplicationContext context;
    @Autowired private MockMvc mockMvc;

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
    public void doesContextContainTomcat(){
    Optional<String> optionalH2 = Arrays.stream(context.getBeanDefinitionNames()).filter(x -> x.contains("tomcat")).findAny();
    Optional<String> optionalTomcat = Arrays.stream(context.getBeanDefinitionNames()).filter(x -> x.contains("h2")).findAny();
    assertTrue(optionalH2.isPresent());
    }
}
