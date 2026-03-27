package com.nirbhay.notesapp.controller;

import com.nirbhay.notesapp.model.User;
import com.nirbhay.notesapp.repository.UserRepository;
import com.nirbhay.notesapp.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User dbUser = optionalUser.get();

        if (!dbUser.getPassword().equals(user.getPassword())) {
            return "Invalid password";
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}