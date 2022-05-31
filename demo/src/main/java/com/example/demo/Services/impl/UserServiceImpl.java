package com.example.demo.Services.impl;

import com.example.demo.DTO.response.UserResponse;
import com.example.demo.entities.User;
import com.example.demo.Services.interfaces.IUserService;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;

@Service
public class UserServiceImpl  implements IUserService {



    @Autowired
    private UserRepository repository;

    /*public User guardarUser(User user){
        return from(repository.save());
    }*/



    @Override
    public UserResponse getUserById(Long id){
        return from(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe")));
    }

    @Override
    public Iterable<User> findAll(){
        return repository.findAll();
    }

    @Override
    public Boolean deleteById(Long id) {

        UserResponse del = getUserById(id);
        if (del != null){
            repository.deleteById(id);
            return true;
        }
        else {
            return false;
        }

    }

    private UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        response.setPhone(user.getPhone());
        response.setPasswordd(user.getPassword());
        return response;
    }

 /*
    public static void update(SingularAttribute<AbstractPersistable, Serializable> id, Map<String, Object> request){
        repository.findById(Long.valueOf(id)).orElseThrow(() ->{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id no encontrada.");
        });
        request.forEach((k,v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, User, v);
        });
    }*/



}
