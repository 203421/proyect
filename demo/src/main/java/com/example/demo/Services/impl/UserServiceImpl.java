package com.example.demo.Services.impl;

import com.example.demo.DTO.response.UserResponse;
import com.example.demo.entities.User;
import com.example.demo.Services.interfaces.IUserService;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserResponse getUserById(Long id){
        return from(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe")));
    }

    private UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }
}
