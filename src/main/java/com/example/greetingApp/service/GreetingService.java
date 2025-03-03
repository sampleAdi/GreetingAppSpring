package com.example.greetingApp.service;

import com.example.greetingApp.model.GreetingEntity;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    // ✅ UC3: Get All Greetings from DB
    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // ✅ UC5: Find Greeting by ID
    public ResponseEntity<GreetingEntity> getGreetingById(Long id) {
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);
        return greeting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    public String getGreetingById(String firstName, String lastName) {
        return firstName;
    }

    public GreetingEntity saveGreeting(GreetingEntity greeting) {
        return greeting;
    }
}
