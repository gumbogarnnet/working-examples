/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.security;

import com.online.bank.online.bank.model.User;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author garnnet
 */
public class UserPrinciples implements UserDetails{
    
    private User user;

    public UserPrinciples(User user) {
        this.user = user;
    }
    
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("User")); 
    }

    @Override
    public String getPassword() {
         return user.getPassword(); 
    }

    @Override
    public String getUsername() {
         return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
         return true; 
    }

    @Override
    public boolean isAccountNonLocked() {
         return true; 
    }

    @Override
    public boolean isCredentialsNonExpired() {
         return true; 
    }

    @Override
    public boolean isEnabled() {
        return true; 
    }
    
}
