/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.security;


import com.online.bank.online.bank.dao.UserDao;
import com.online.bank.online.bank.model.User;
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw  new UsernameNotFoundException("user not found");
        }
        return new UserPrinciples(user); 
    }
    
    
    
}
