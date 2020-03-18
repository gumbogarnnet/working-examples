/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springbootexceptionhandling.dao;

import com.example.springbootexceptionhandling.mapper.BirdMapper;
import com.example.springbootexceptionhandling.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author garnnet
 */
@Service
public class BirdDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Bird findBirdByName(String name) {
        String query = "select * from bird where SCIENTIFIC_NAME = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{name}, new BirdMapper());
    }

    public boolean isBirdNameExists(String name) {
        String sql = "select * from bird where SCIENTIFIC_NAME = ?";
        try{
        return jdbcTemplate.queryForObject(sql, Boolean.class, name);
        }
        catch (EmptyResultDataAccessException ex){
        return false;
        }
        catch(IncorrectResultSetColumnCountException tyh){
        return true;
        }
    }
        
}
