package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Acceptance test queries the endpoint, and the flow goes the whole way down.
 * This requires @SpringBootTest to create the application for us.
 */
@SpringBootTest
@AutoConfigureMockMvc
class WelcomeControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome, Stranger!")));
    }

    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {
        mockMvc.perform(get("/welcome?name=George"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome, George!")));
    }

}