package com.example.formLogin.request;

import lombok.Data;

@Data
public class UserRequest {

    private Long id;

    private String username;

    private String password;
}
