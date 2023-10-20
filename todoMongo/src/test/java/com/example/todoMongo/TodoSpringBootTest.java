package com.example.todoMongo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TodoSpringBootTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ApplicationContext context;

    @Test
    public  void mockMvcNotNull(){
        assertNotNull(mockMvc);
    }

    @Test
    public  void containerNotNull(){
        assertNotNull(context);
    }

    @Test
    public void getTodos() throws Exception{
//        when(mockMvc)
        this.mockMvc.perform(
                get("/todos").contentType("application/json")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void postTodos() throws Exception{
        String body = new JSONObject(Map.of("description", "hi", "completed", false)).toString();
        this.mockMvc.perform(
                post("/todos").contentType("application/json").content(body)
        ).andDo(print()).andExpect(status().isOk());

        MvcResult result =  this.mockMvc.perform(
                get("/todos").contentType("application/json")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        JSONArray respJson = new JSONArray(result.getResponse().getContentAsString());
        JSONObject todoJson = respJson.getJSONObject(0);

        assertEquals("hi", todoJson.getString("description"));
        assertEquals(false, todoJson.getBoolean("completed"));
        assertNotNull(todoJson.getInt("id"));

        result =  this.mockMvc.perform(
                get("/todos/1").contentType("application/json")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        todoJson = new JSONObject(result.getResponse().getContentAsString());
        assertEquals("hi", todoJson.getString("description"));
        assertEquals(false, todoJson.getBoolean("completed"));
        assertNotNull(todoJson.getInt("id"));
    }

    @Test
    public void deleteTodos() throws Exception{
        String body = new JSONObject(Map.of("description", "hi", "completed", false)).toString();
        this.mockMvc.perform(
                post("/todos").contentType("application/json").content(body)
        ).andDo(print()).andExpect(status().isOk());

        this.mockMvc.perform(
                delete("/todos/1")
        ).andDo(print()).andExpect(status().isOk());

        this.mockMvc.perform(
                delete("/todos/1")
        ).andDo(print()).andExpect(status().isNotFound());


    }

}