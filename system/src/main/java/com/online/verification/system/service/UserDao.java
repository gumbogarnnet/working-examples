package com.online.verification.system.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.online.verification.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author ggumbo
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    
    User findByUserName(String userName);
    
}
