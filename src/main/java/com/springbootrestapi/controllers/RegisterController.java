package com.springbootrestapi.controllers;

import com.springbootrestapi.models.User;
import com.springbootrestapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    private UserService userService;
    public RegisterController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody User user){
        String response = "User with email "+user.getEmail()+" exists";
        if(!userService.getUserByEmail(user.getEmail())) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userService.saveUser(user);
            response="user created";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
