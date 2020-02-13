/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.mapper;

import com.online.bank.online.bank.model.Appointments;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author garnnet
 */
public class AppointmentsMapper implements RowMapper<Appointments>{

    @Override
    public Appointments mapRow(ResultSet rs, int i) throws SQLException {
        Appointments appointments = new Appointments();
        appointments.setAppointmentDate(rs.getDate("appointment_date"));
        appointments.setDescription(rs.getString("description"));
        appointments.setEmail(rs.getString("email"));
        appointments.setLocation(rs.getString("location"));
        appointments.setStatus(rs.getString("status"));
        return appointments;
        
    }
    
}
