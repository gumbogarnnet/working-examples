/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.model;

import java.util.Date;

/**
 *
 * @author garnnet
 */
public class History {

    private String email;
    private Date date;
    private String description;
    private String type;
    private String status;
    private Integer amount;
    private Integer availableBalance;

    public History() {
    }

    public History(String email, Date date, String description, String type, String status, Integer amount, Integer availableBalance) {
        this.email = email;
        this.date = date;
        this.description = description;
        this.type = type;
        this.status = status;
        this.amount = amount;
        this.availableBalance = availableBalance;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public String toString() {
        return "SavingsItem{" + "email=" + email + ", date=" + date + ", description=" + description + ", type=" + type + ", status=" + status + ", amount=" + amount + ", availableBalance=" + availableBalance + '}';
    }
    
    

}
