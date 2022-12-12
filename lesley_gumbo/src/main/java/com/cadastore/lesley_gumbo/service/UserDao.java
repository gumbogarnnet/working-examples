/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastore.lesley_gumbo.service;

import com.cadastore.lesley_gumbo.entity.User;
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
