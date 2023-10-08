package com.example.demo.controller;

import com.example.demo.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests check that our code integrates with the spring APIs.
 * This doesn't need to be a SpringTest as the spring application isn't required.
 */
@WebMvcTest
class WelcomeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WelcomeService welcomeService;

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        // When the welcomeService logic is called with 'Stranger', return 'Welcome Stranger!'
        when(welcomeService.getWelcomeMessage("Stranger")).thenReturn("Welcome Stranger!");
        // Request the '/welcome' endpoint.
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                // Expect the correct response.
                .andExpect(content().string(equalTo("Welcome Stranger!")));
        // Verify that the welcomeService was actually called.
        verify(welcomeService).getWelcomeMessage("Stranger");
    }

    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {
        when(welcomeService.getWelcomeMessage("John")).thenReturn("Welcome John!");
        mockMvc.perform(get("/welcome?name=John"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome John!")));
        verify(welcomeService).getWelcomeMessage("John");
    }
}