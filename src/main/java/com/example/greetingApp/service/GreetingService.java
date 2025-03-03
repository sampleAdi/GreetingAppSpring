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

    // ✅ UC1: Default Greeting
    public GreetingEntity defaultGreeting() {
        return new GreetingEntity("Hello, World!");
    }

    // ✅ UC2: Personalized Greeting
    public GreetingEntity personalizedGreeting(String name) {
        return new GreetingEntity("Hello, " + name + "!");
    }

    // ✅ UC3: Save Greeting
    public GreetingEntity saveGreeting(GreetingEntity greeting) {
        return greetingRepository.save(greeting);
    }

    // ✅ UC4: Get Greeting by ID
    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // ✅ UC5: Update Greeting using Query Param
    public GreetingEntity updateGreeting(Long id, String message) {
        Optional<GreetingEntity> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            GreetingEntity existingGreeting = optionalGreeting.get();
            existingGreeting.setMessage(message);
            return greetingRepository.save(existingGreeting);
        } else {
            throw new RuntimeException("Greeting not found with id: " + id);
        }
    }

    // ✅ UC6: List All Greetings
    public List<GreetingEntity> listAllGreetings() {
        return greetingRepository.findAll();
    }

    // ✅ UC7: Edit a Greeting Message using Request Body
    public GreetingEntity editGreeting(Long id, GreetingEntity newGreeting) {
        Optional<GreetingEntity> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            GreetingEntity existingGreeting = optionalGreeting.get();
            existingGreeting.setMessage(newGreeting.getMessage());  // Updating only the message
            return greetingRepository.save(existingGreeting);
        } else {
            throw new RuntimeException("Greeting not found with id: " + id);
        }
    }
}
