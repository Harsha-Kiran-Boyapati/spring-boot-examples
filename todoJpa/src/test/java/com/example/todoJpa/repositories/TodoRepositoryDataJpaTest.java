package com.example.todoJpa.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

@DataJpaTest
public class TodoRepositoryDataJpaTest {
    @Autowired private ApplicationContext context;
    @Autowired private TodoRepository todoRepository;

    @Test
    public void contextLoads(){
        Assertions.assertNotNull(context);
        Assertions.assertNotNull(todoRepository);
    }
}
