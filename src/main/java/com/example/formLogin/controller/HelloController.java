package com.example.formLogin.controller;

import com.example.formLogin.response.HelloResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/formLogin")
public class HelloController {

    @GetMapping
    public ResponseEntity<HelloResponse> sayHello() {
        HelloResponse res = HelloResponse.builder()
                .message("Hello world with springboot")
                .build();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
}
