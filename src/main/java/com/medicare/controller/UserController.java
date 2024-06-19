package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.model.UserModel;
import com.medicare.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user")
    public UserModel getUserByEmail(@RequestBody String userInputEmail) {
        return userRepo.findUserByEmail(userInputEmail);
    }
}
