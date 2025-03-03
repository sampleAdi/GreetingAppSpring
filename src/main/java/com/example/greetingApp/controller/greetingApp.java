package com.example.greetingApp.controller;

import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class greetingApp {  // ✅ Class name greetingApp hai, isko maintain rakha hai.

    private final GreetingService greetingService;

    // Constructor Injection
    public greetingApp(GreetingService greetingService) {  // ✅ Constructor name bhi same as class name
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }
}
