/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Gumbo
 */
@Entity 
@Data
public class Library {
    @Id
    private Integer libraryID;
    private String libraryName;
    private String address;
    
    
}
