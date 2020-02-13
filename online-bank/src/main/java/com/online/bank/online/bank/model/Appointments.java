/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author garnnet
 */
public class Appointments {
   
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    private Date appointmentDate;
    private String location;
    private String description;
    private String status;

    public Appointments() {
    }

    public Appointments(String email, Date appointmentDate, String location, String description, String status) {
        this.email = email;
        this.appointmentDate = appointmentDate;
        this.location = location;
        this.description = description;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointments{" + "email=" + email + ", appointmentDate=" + appointmentDate + ", location=" + location + ", description=" + description + ", status=" + status + '}';
    }
    
    
    
    
}
