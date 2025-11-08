package com.wbjee.oceanapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wbjee.oceanapp.service.UserService;
import com.wbjee.oceanapp.model.User;
import com.wbjee.oceanapp.dto.auth.RegisterRequest;
import com.wbjee.oceanapp.dto.auth.AuthResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {
        if (req.getEmail() == null || req.getPassword() == null) {
            return ResponseEntity.badRequest().body(new AuthResponse(null, "Email and password required"));
        }
        User u = new User();
        u.setUsername(req.getUsername());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        User saved = userService.register(u);
        return ResponseEntity.ok(new AuthResponse(saved.getId(), "User registered"));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody RegisterRequest req) {
        User u = userService.login(req.getEmail(), req.getPassword());
        return ResponseEntity.ok(new AuthResponse(u.getId(), "Login successful"));
    }
}
