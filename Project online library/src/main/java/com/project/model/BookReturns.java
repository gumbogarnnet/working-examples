/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Gumbo
 */
@Entity
@Data
public class BookReturns {
    @Id
     private Integer id;
     private Date returnDate;
     private Integer penalty;
    
    
}
