/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.cart.shopping_cart.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author garnnet
 */
@Entity
@Data
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer orderId;
    private Integer productId;
    
    private String country;
    private String address;
    private Integer phoneNumber;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

}
