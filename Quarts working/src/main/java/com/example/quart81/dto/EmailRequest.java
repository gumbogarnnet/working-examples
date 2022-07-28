/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.quart81.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author G Gumbo
 */
@Data
public class EmailRequest {

    @Email
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String subject;

    @NotEmpty
    private String body;
   
    @NotNull
    private LocalDateTime dateTime;
    
    @NotNull
    private ZoneId timeZone;

}
