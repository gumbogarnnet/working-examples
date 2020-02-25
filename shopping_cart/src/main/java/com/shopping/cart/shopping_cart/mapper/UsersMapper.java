/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.cart.shopping_cart.mapper;

import com.shopping.cart.shopping_cart.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author garnnet
 */
public class UsersMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
     User users = new User();
     users.setDate(rs.getDate("date"));
     users.setEmail(rs.getString("email"));
     users.setId(rs.getInt("id"));
     users.setRole(rs.getString("role"));
     users.setUsername(rs.getString("username"));
    return users; 
    }
    
}
