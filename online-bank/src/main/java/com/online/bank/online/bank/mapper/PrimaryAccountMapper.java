/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.mapper;

import com.online.bank.online.bank.model.PrimaryAccount;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author garnnet
 */
public class PrimaryAccountMapper implements RowMapper<PrimaryAccount> {

    @Override
    public PrimaryAccount mapRow(ResultSet rs, int i) throws SQLException {

        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountNumber(rs.getInt("account_number"));
        primaryAccount.setBalance(rs.getInt("balance"));
        primaryAccount.setEmail(rs.getString("email"));
        
        return primaryAccount;
    }

}
