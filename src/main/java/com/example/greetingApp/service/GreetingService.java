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
        return new GreetingEntity("Hello, Welcome to Greeting App!");
    }

    // ✅ UC2: Greeting with Name
    public GreetingEntity personalizedGreeting(String name) {
        return new GreetingEntity("Hello, " + name + "! Welcome to Greeting App.");
    }

    // ✅ UC3: Save Greeting
    public GreetingEntity saveGreeting(GreetingEntity greeting) {
        return greetingRepository.save(greeting);
    }

    // ✅ UC4: Get Greeting by ID
    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // ✅ UC5: Update Greeting
    public GreetingEntity updateGreeting(Long id, String message) {
        Optional<GreetingEntity> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            GreetingEntity greeting = optionalGreeting.get();
            greeting.setMessage(message);
            return greetingRepository.save(greeting);
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }

    // ✅ UC6: List All Greetings
    public List<GreetingEntity> listAllGreetings() {
        return greetingRepository.findAll();
    }

    // ✅ UC7: Edit Greeting Message (PATCH)
    public GreetingEntity editGreeting(Long id, String message) {
        Optional<GreetingEntity> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            GreetingEntity greeting = optionalGreeting.get();
            greeting.setMessage(message);
            return greetingRepository.save(greeting);
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }

    // ✅ UC8: Delete a Greeting Message
    public String deleteGreeting(Long id) {
        Optional<GreetingEntity> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            greetingRepository.deleteById(id);
            return "Greeting with ID " + id + " has been deleted successfully.";
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }
}