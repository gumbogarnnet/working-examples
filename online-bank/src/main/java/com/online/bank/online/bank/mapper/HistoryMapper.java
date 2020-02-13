/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.mapper;


import com.online.bank.online.bank.model.History;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;




/**
 *
 * @author garnnet
 */
public class HistoryMapper implements RowMapper<History>{

    @Override
    public History mapRow(ResultSet rs, int i) throws SQLException {
    History savingsItem= new History();
    savingsItem.setAmount(rs.getInt("amount"));
    savingsItem.setAvailableBalance(rs.getInt("available_balance"));
    savingsItem.setDate(rs.getDate("date"));
    savingsItem.setDescription(rs.getString("description"));
    savingsItem.setEmail(rs.getString("email"));
    savingsItem.setStatus(rs.getString("status"));
    savingsItem.setType(rs.getString("type"));
    return savingsItem;
   }

    
    
}
