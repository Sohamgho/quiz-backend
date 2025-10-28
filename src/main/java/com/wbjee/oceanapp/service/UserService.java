package com.wbjee.oceanapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.wbjee.oceanapp.model.User;
import com.wbjee.oceanapp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // sign up
    @Transactional
    public String registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "Email already registered!";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    // sign in
    public String login(String email, String rawPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return "User not found!";
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            return "Incorrect password!";
        }
        return "Login successful!";
    }

    // get user
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Admin
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // remove user 
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
