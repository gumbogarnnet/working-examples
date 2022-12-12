package com.online.verification.system.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.online.verification.system.entity.User;
import com.online.verification.system.service.UserDao;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ggumbo
 */
@RestController
@Slf4j
public class UserRestController {

    @Autowired
    UserDao userDao;

    @PostMapping("/postregisteruser")
    @CrossOrigin(origins = "*")
    public String registerUser(@RequestBody User user) {
    User user1 = userDao.findByUserName(user.getUserName());
    if(user1!=null)return "Username already in use";
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword); 
        userDao.save(user);
        
        return "Saved Successfully";

    }
    @GetMapping("/getallusers")
    @CrossOrigin(origins = "*")
    public List<User> getAllUsers(){
    return userDao.findAll();
    }

}
