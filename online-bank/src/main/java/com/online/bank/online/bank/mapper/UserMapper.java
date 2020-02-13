/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.mapper;

import com.online.bank.online.bank.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Gumbo
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setEmail(rs.getString("email"));
        user.setFirstName((rs.getString("first_name")));
        user.setLastName((rs.getString("last_name")));
        user.setPassword((rs.getString("password")));
        user.setPhoneNumber((rs.getInt("phone_number")));
        user.setStatus((rs.getString("status")));
        user.setUserName((rs.getString("user_name")));
        
        return user;
    }
    
}
