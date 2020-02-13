/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.dao;

import com.online.bank.online.bank.mapper.PrimaryAccountMapper;
import com.online.bank.online.bank.model.PrimaryAccount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author garnnet
 */
@Repository
public class PrimaryAccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<PrimaryAccount> findAll(){
    return jdbcTemplate.query("select * from primary_account", new PrimaryAccountMapper());
    }
    
    public PrimaryAccount findByEmail(String email) {

        return jdbcTemplate.queryForObject("select * from primary_account where email=? ", new Object[]{email}, new PrimaryAccountMapper());
    }

    public int deposit(Integer amount, String email, String account) {
      String query = "update primary_account set balance = balance + ? where email = ?";
        return jdbcTemplate.update(query, amount, email );  
    }

    public int withdraw(Integer amount, String email, String account) {
      String query = "update primary_account set balance = balance - ? where email = ?";
        return jdbcTemplate.update(query, amount, email ); 
    }

    public int save(int primaryNumber, String email) {
    String query = "INSERT INTO `primary_account` (`account_number`, `email`, `balance`) VALUES (?, ?, '0');";
        return jdbcTemplate.update(query, primaryNumber, email ); 
    }

   
}
