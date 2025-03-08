package com.example.greetingApp.controller;

import com.example.greetingApp.DTOs.PasswordUpdateRequest;
import com.example.greetingApp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    // ✅ Forgot Password API
    @PutMapping("/forgotPassword/{email}")
    public ResponseEntity<?> forgotPassword(@PathVariable String email, @RequestBody PasswordUpdateRequest request) {
        String response = authenticationService.forgotPassword(email, request);
        return ResponseEntity.ok().body("{\"message\": \"" + response + "\"}");
    }

    // ✅ Reset Password API
    @PutMapping("/resetPassword/{email}")
    public ResponseEntity<?> resetPassword(@PathVariable String email, @RequestBody PasswordUpdateRequest request) {
        String response = authenticationService.resetPassword(email, request);
        return ResponseEntity.ok().body("{\"message\": \"" + response + "\"}");
    }
}