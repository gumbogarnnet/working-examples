/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springbootexceptionhandling.mapper;

import com.example.springbootexceptionhandling.model.Bird;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author garnnet
 */
public class BirdMapper implements RowMapper<Bird>{

    @Override
    public Bird mapRow(ResultSet rs, int i) throws SQLException {
    Bird bird = new Bird();
    bird.setId(rs.getLong("ID"));
    bird.setLength(rs.getInt("LENGTH"));
    bird.setMass(rs.getDouble("MASS"));
    bird.setScientificName(rs.getString("SCIENTIFIC_NAME"));
    bird.setSpecie(rs.getString("SPECIE"));
    return bird;
    }
    
}
