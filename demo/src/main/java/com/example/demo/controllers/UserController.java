package com.example.demo.controllers;


import com.example.demo.DTO.response.UserResponse;
import com.example.demo.Services.interfaces.IUserService;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("getAll")
    public Iterable<User> getAll(){
        return service.findAll();
    }
    @Autowired
    private IUserService service;

    @GetMapping("{id}")
    public UserResponse getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id){
        //UserResponse del = service.getUserById(id);

         boolean status = service.deleteById(id);

        return true;
    }

}
