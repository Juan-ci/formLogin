package com.example.formLogin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity("OK", HttpStatus.OK);
    }
}
