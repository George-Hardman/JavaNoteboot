package com.example.demo.controller;

import com.example.demo.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controllers contain the endpoints.
 */
@RestController
public class WelcomeController {
    // When the service is created, the business logic is autowired in.
    @Autowired
    private WelcomeService welcomeService;

    // Construct the welcome controller with the business logic.
    public WelcomeController(WelcomeService welcomeService){
        this.welcomeService = welcomeService;
    }

    /**
     * Creates an endpoint at '/welcome'
     * @param name the name from the request param
     * @return the return string.
     */
    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "Stranger") String name){
        return welcomeService.getWelcomeMessage(name);
    }
}
