/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.cart.shopping_cart.service;

import com.shopping.cart.shopping_cart.mapper.ItemMapper;
import com.shopping.cart.shopping_cart.model.Product;
import com.shopping.cart.shopping_cart.dto.ShoppingCartDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author garnnet
 */
@Service
public class ItemService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getLatestProducts() {
        String query = "SELECT * FROM `product` ORDER BY id DESC LIMIT 10";
        return jdbcTemplate.query(query, new ItemMapper());
    }

    public List<Product> getProducts(String cartegory) {
        String query = "SELECT * FROM `product` WHERE `cartegory`= ?";
        return jdbcTemplate.query(query, new Object[]{cartegory}, new ItemMapper());
    }

    public List<Product> getCartProducts(List<Integer> ids) {
        String query = "SELECT * FROM `product` WHERE `id`= ?";
        List<Product> itemsList = new ArrayList<>();

        for (Integer id : ids) {
            itemsList.add(jdbcTemplate.queryForObject(query, new Object[]{id}, new ItemMapper()));
        }

        return itemsList;

    }

}
