package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * Services contain business logic.
 */
@Service
public class WelcomeService {

    public String getWelcomeMessage(String name){
        return String.format("Welcome, %s!", name);
    }
}
