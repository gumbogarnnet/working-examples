/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.cart.shopping_cart.dto;

import com.shopping.cart.shopping_cart.model.Product;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author garnnet
 */
@Data
public class OrdersDto {
    
     private String country;
            private String address;
            private Integer phoneNumber;
            private String email;
            private List<Product> cartProducts;
            
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
