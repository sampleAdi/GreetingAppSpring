package com.example.greetingApp.controller;

import com.example.greetingApp.model.GreetingEntity;
import com.example.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greetings")
public class greetingApp {

    @Autowired
    private GreetingService greetingService;

    // ✅ UC1: Default Greeting
    @GetMapping("/default")
    public GreetingEntity getDefaultGreeting() {
        return greetingService.defaultGreeting();
    }

    // ✅ UC2: Greeting with Name
    @GetMapping("/{name}")
    public GreetingEntity getPersonalizedGreeting(@PathVariable String name) {
        return greetingService.personalizedGreeting(name);
    }

    // ✅ UC3: Save Greeting
    @PostMapping("/save")
    public GreetingEntity saveGreeting(@RequestBody GreetingEntity greeting) {
        return greetingService.saveGreeting(greeting);
    }

    // ✅ UC4: Get Greeting by ID
    @GetMapping("/get/{id}")
    public Optional<GreetingEntity> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // ✅ UC5: Update Greeting
    @PutMapping("/update/{id}")
    public GreetingEntity updateGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }

    // ✅ UC6: List All Greetings
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.listAllGreetings();
    }
}
