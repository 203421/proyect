package com.example.demo.Services.interfaces;

import com.example.demo.DTO.response.UserResponse;

public interface IUserService {
    UserResponse getUserById(Long id);

    Boolean deleteById(Long id);
}
