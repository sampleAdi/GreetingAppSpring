package com.example.greetingApp.service;

import com.example.greetingApp.model.GreetingEntity;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    // UC1: Default Greeting
    public GreetingEntity defaultGreeting() {
        return new GreetingEntity("Hello, World!");
    }

    // UC2: Greeting with Name
    public GreetingEntity personalizedGreeting(String name) {
        return new GreetingEntity("Hello, " + name + "!");
    }

    // UC3: Save Greeting
    public GreetingEntity saveGreeting(GreetingEntity greeting) {
        return greetingRepository.save(greeting);
    }

    // UC4: Get Greeting by ID
    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // UC5: Update Greeting
    public GreetingEntity updateGreeting(Long id, String message) {
        return greetingRepository.findById(id).map(g -> {
            g.setMessage(message);
            return greetingRepository.save(g);
        }).orElse(null);
    }

    // UC6: List All Greetings
    public List<GreetingEntity> listAllGreetings() {
        return greetingRepository.findAll();
    }
}
