package com.example.greetingApp.service;

import com.example.greetingApp.model.GreetingEntity;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName == null && lastName == null) {
            return "Hello, World!";
        }
        return "Hello, " + (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "") + "!";
    }

    public GreetingEntity saveGreeting(GreetingEntity greeting) {
        if (greeting.getMessage() == null || greeting.getMessage().trim().isEmpty()) {
            greeting.setMessage("Default Greeting Message");
        }

        if (greeting.getId() != null) {
            Optional<GreetingEntity> existingGreeting = greetingRepository.findById(greeting.getId());
            if (existingGreeting.isPresent()) {
                GreetingEntity updatedGreeting = existingGreeting.get();
                updatedGreeting.setMessage(greeting.getMessage());
                return greetingRepository.save(updatedGreeting);
            }
        }

        return greetingRepository.save(greeting);
    }

    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
}
