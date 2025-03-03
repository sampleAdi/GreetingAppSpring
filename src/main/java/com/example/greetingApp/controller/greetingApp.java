package com.example.greetingApp.controller;

import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class greetingApp {

    private final GreetingService greetingService;

    // Constructor Injection
    public greetingApp(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getGreetingMessage(firstName, lastName) + "\"}";
    }

    @PostMapping
    public String postGreeting() {
        return "{\"message\": \"Hello from POST!\"}";
    }

    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"Hello from PUT!\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Hello from DELETE!\"}";
    }
}
