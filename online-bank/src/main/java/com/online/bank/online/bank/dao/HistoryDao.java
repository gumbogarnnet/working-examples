/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.dao;

import com.online.bank.online.bank.mapper.HistoryMapper;
import com.online.bank.online.bank.model.History;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author garnnet
 */
@Repository
public class HistoryDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(Integer amount, String email, String account, Integer balance, String type) {
    String query = "INSERT INTO `history` (`email`, `date`, `description`, `type`, `status`, `amount`, `available_balance`) VALUES (?, current_timestamp(), ?, ?, 'processed', ?, ?)"; 
    return jdbcTemplate.update(query, email, account, type, amount, balance  );
    }

    public List<History> getprimary(String email) {
    return jdbcTemplate.query("select * from history where email=? and description='primary'", new Object[]{email}, new HistoryMapper());    
    }

    public List<History> getSavings(String email) {
    return jdbcTemplate.query("select * from history where email=? and description='savings'", new Object[]{email}, new HistoryMapper());    
   
    }
    
    
    
}
