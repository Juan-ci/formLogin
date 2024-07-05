package com.example.formLogin.service.impl;

import com.example.formLogin.entity.User;
import com.example.formLogin.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Override
    public List<User> getAllUsers() {
        return List.of(
            new User(1L, "Jhon", "Doe"),
                new User(2L, "Cosme", "Fulanito"),
                new User(3L, "Frank", "Sinatra"),
                new User(4L, "Emiliano", "Martinez"),
                new User(5L, "Lind L.", "Taylor")
        );
    }
}
