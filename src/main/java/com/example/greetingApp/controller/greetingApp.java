package com.example.greetingApp.controller;

import com.example.greetingApp.model.GreetingEntity;
import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
class GreetingAppController {

    private final GreetingService greetingService;

    public GreetingAppController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // ✅ UC1: Default Greeting Message
    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getGreetingMessage(firstName, lastName) + "\"}";
    }

    // ✅ UC2: Save Greeting Message (POST)
    @PostMapping
    public GreetingEntity saveGreeting(@RequestBody GreetingEntity greeting) {
        return greetingService.saveGreeting(greeting);
    }

    // ✅ UC3: Get all greetings from DB
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // ✅ UC4: Get Greeting by ID
    @GetMapping("/{id}")
    public Optional<GreetingEntity> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
}
