package com.example.demo.controllers;


import com.example.demo.DTO.response.UserResponse;
import com.example.demo.Services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("{id}")
    public UserResponse holi(@PathVariable Long id) {
        return service.getUserById(id);
    }


    //Miller es reputisimo
}
