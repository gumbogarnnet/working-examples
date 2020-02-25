/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.cart.shopping_cart.mapper;

import com.shopping.cart.shopping_cart.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author garnnet
 */
public class ItemMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
    Product item = new Product();
    item.setCartegory(rs.getString("cartegory"));
    item.setDescription(rs.getString("description"));
    item.setName(rs.getString("name"));
    item.setPrice(rs.getDouble("price"));
    item.setImage(rs.getBytes("image"));
    item.setId(rs.getInt("id"));
    return item;
    }
    
}
