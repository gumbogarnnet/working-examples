/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.dao;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author garnnet
 */
@Service
public class AppointmentsDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(String description, String email, Date appointmentDate, String status, String location) {
   

        String query = "INSERT INTO `appointments` (`description`, `email`, `appointment_date`, `status`, `location`) VALUES (?, ?, ?, 'pending', ?)";
        return jdbcTemplate.update(query, new Object[]{description, email, appointmentDate, location});
    
    }
    
}
