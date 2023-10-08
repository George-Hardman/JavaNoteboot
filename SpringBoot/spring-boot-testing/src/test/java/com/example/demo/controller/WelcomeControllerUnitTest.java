package com.example.demo.controller;

import com.example.demo.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit tests check our functions work correctly
 */
class WelcomeControllerUnitTest {

    @Test
    void shouldWelcome(){

        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
        when(welcomeService.getWelcomeMessage("George")).thenReturn("Welcome, George!");
        WelcomeController welcomeController = new WelcomeController(welcomeService);
        assertEquals("Welcome, George!", welcomeController.welcome("George"));
    }

}