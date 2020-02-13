/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.mapper;

import com.online.bank.online.bank.model.UserView;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author garnnet
 */
public class UserViewMapper implements RowMapper<UserView>{

    @Override
    public UserView mapRow(ResultSet rs, int i) throws SQLException {
        UserView userView = new UserView();
        userView.setEmail(rs.getString("email"));
        userView.setFirstName(rs.getString("name"));
        userView.setPhoneNumber(rs.getInt("phone_number"));
        userView.setAccountNumber(rs.getInt("account_number"));
        return userView;
        
    }
    
}
