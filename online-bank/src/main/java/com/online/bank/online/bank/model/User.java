/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.model;

import lombok.Data;

/**
 *
 * @author Gumbo
 */
@Data
public class User {

    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private String userName;
    private String password;
    private String status;

    

}
