package com.example.assignment.controller;

import com.example.assignment.model.User;
import com.example.assignment.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = usersRepository.findByUsername(user.getUsername());
        if (existingUser != null && bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return new ResponseEntity<>("User successfully logged in", HttpStatus.OK);
            // User logged in successfully
            // You can implement your own logic here, such as generating and returning a JWT token
        } else {
            return new ResponseEntity<>("User successfully logged in", HttpStatus.OK);
            // Invalid login credentials
            // You can handle this according to your application's requirements
        }
    }

    @PostMapping("/reset-password")
    public void resetPassword(@RequestParam String username, @RequestParam String newPassword) {
        User user = usersRepository.findByUsername(username);
        if (user != null) {
            user.setPassword(bCryptPasswordEncoder.encode(newPassword));
            usersRepository.save(user);
        } else {
            // User not found
            // You can handle this according to your application's requirements
        }
    }


}
