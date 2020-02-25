/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.cart.shopping_cart.repository;

import com.shopping.cart.shopping_cart.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author garnnet
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderLine, Integer>{
    
}
