package com.example.formLogin.service;

import com.example.formLogin.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersService {

    List<User> getAllUsers();
}
