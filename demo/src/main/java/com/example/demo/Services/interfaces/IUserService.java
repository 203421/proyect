package com.example.demo.Services.interfaces;

import com.example.demo.DTO.response.UserResponse;
import com.example.demo.entities.User;

public interface IUserService {
    UserResponse getUserById(Long id);

    Iterable<User> findAll();

    Boolean deleteById(Long id);


}
