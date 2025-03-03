package com.example.greetingApp.controller;

import com.example.greetingApp.model.GreetingEntity;
import com.example.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
class GreetingAppController {

    @Autowired
    private GreetingService greetingService;

    // ✅ UC1: Get Greeting Message
    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getGreetingById(firstName, lastName) + "\"}";
    }

    // ✅ UC2: Save Greeting Message
    @PostMapping
    public GreetingEntity saveGreeting(@RequestBody GreetingEntity greeting) {
        return greetingService.saveGreeting(greeting);
    }

    // ✅ UC3: Get All Greetings
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // ✅ UC5: Find Greeting by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
}
