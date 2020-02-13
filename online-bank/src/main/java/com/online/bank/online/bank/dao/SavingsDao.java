/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.dao;

import com.online.bank.online.bank.mapper.SavingsMapper;
import com.online.bank.online.bank.mapper.UserViewMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.online.bank.online.bank.model.Savings;
import com.online.bank.online.bank.model.UserView;
import org.springframework.stereotype.Repository;

/**
 *
 * @author garnnet
 */
@Repository
public class SavingsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<Savings> findAll(){
    return jdbcTemplate.query("select * from savings", new SavingsMapper());
    
    }
    
    public Savings findByEmail(String email) {

        return jdbcTemplate.queryForObject("select * from savings where email=?", new Object[]{email}, new SavingsMapper());
    }



    public int deposit(Integer amount, String email, String account) {
     String query = "update savings set balance = balance + ? where email = ?";
        return jdbcTemplate.update(query, amount, email );
        
    }

    public int withdraw(Integer amount, String email, String account) {
     String query = "update savings set balance = balance - ? where email = ?";
        return jdbcTemplate.update(query, amount, email );    
    }

    public int save(int accountNumber, String email) {
        String query = "INSERT INTO `savings` (`account_number`, `email`, `balance`) VALUES (?, ?, '0');";
        return jdbcTemplate.update(query, accountNumber, email );
    }

    public List<Savings> findAllexp(String name) {
      return jdbcTemplate.query("select * from savings where email not like ?", new Object[]{name}, new SavingsMapper());   
    }

    public Savings findByAccountNumber(Integer accountNumber) {
       return jdbcTemplate.queryForObject("select * from savings where account_number=?", new Object[]{accountNumber}, new SavingsMapper());
       
    }

    public List<UserView> findAllviewexp(String name) {
      return jdbcTemplate.query("select * from user_view where email not like ?", new Object[]{name}, new UserViewMapper());   
        
    }
}
    

