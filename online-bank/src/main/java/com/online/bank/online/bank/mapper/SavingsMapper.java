/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.mapper;

import com.online.bank.online.bank.model.Savings;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author garnnet
 */
public class SavingsMapper implements RowMapper<Savings> {

    @Override
    public Savings mapRow(ResultSet rs, int i) throws SQLException {
    Savings savings = new Savings();
    savings.setAccountNumber(rs.getInt("account_number"));
    savings.setBalance(rs.getInt("balance"));
    savings.setEmail(rs.getString("email"));
    return savings;
    }
    
}
