/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.cart.shopping_cart.service;

import com.shopping.cart.shopping_cart.mapper.UsersMapper;
import com.shopping.cart.shopping_cart.model.Product;
import com.shopping.cart.shopping_cart.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author garnnet
 */
@Service
public class UserService {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getTotalCustomers() {
        String query = "SELECT * FROM `user` ";
       
         return jdbcTemplate.query(query,  new UsersMapper());
        
    }
    
}
