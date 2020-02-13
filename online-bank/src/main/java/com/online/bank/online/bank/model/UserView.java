/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.model;

/**
 *
 * @author garnnet
 */
public class UserView {
    private String firstName;
    private Integer phoneNumber;
    private Integer accountNumber;
    private String email;

    public UserView() {
    }

    
    public UserView(String firstName, Integer phoneNumber, Integer accountNumber, String email) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserView{" + "firstName=" + firstName + ", phoneNumber=" + phoneNumber + ", accountNumber=" + accountNumber + ", email=" + email + '}';
    }
    
    
}
