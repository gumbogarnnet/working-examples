package com.online.bank.online.bank.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.online.bank.online.bank.mapper.UserMapper;
import com.online.bank.online.bank.model.User;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import org.springframework.stereotype.Repository;

/**
 *
 * @author garnnet
 */
@Repository
@Slf4j
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User findByEmail(String email) {

        return jdbcTemplate.queryForObject("select * from user where email=?", new Object[]{email}, new UserMapper());
    }

    public List<User> findAll() {

        return jdbcTemplate.query("select * from user", new UserMapper());
    }
//works
//    =====================
    public void save1(User user) {
        
     SimpleJdbcInsert insertUser = new SimpleJdbcInsert(jdbcTemplate);
    insertUser.withTableName("user").usingColumns("email", "first_name", "last_name", "password", "phone_number", "status", "user_name");
    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
     
    insertUser.execute(param);    
    }
//    ================================
    public int save(User user) {

        String query = "INSERT INTO `user` (`first_name`, `last_name`, `email`, `password`, `user_name`, `phone_number`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, new Object[]{user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getUserName(), user.getPhoneNumber(), user.getStatus()});
    }

    public int edit(User user) {
     String query = "UPDATE `user` SET `first_name` = ?, `last_name` = ?, `user_name` = ?, `phone_number` = ? WHERE `user`.`email` = ?";
        return jdbcTemplate.update(query, new Object[]{user.getFirstName(), user.getLastName(), user.getUserName(), user.getPhoneNumber(), user.getEmail()});
    }

}
