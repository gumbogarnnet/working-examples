package com.online.verification.system.security;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import com.online.verification.system.entity.User;
import com.online.verification.system.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author garnnet
 */
@Service
public class SecurityService implements UserDetailsService {
    
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        User user = userDao.findByUserName(username);
        if (user == null) {
            throw  new UsernameNotFoundException("user not found");
        }
        return new UserPrinciples(user); 
    }
    
    
    
}
