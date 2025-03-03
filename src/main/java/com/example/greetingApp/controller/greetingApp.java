package com.example.greetingApp.controller;

import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class greetingApp {  // ✅

    private final GreetingService greetingService;

    // Constructor Injection
    public greetingApp(GreetingService greetingService) {  // ✅
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }
}
