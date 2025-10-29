package com.selimhorri.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selimhorri.app.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerE2ETest {



    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateUser() throws Exception {
        User user = User.builder()
                .firstName("Alice")
                .lastName("M Wonderland")
                .email("alice@wonder.land")
                .phone("555-0000")
                .imageUrl("profile.jpg")
                .build();

        mockMvc.perform(post("/user-service/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("alice@wonder.land"));
    }

    @Test
    public void shouldGetAllUsers() throws Exception {
        mockMvc.perform(get("/user-service/api/users"))
                .andExpect(status().isOk());
    }
}
