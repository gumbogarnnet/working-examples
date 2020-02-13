/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.dto;

/**
 *
 * @author garnnet
 */
public class DepositDto {
    
    private String accountType;
    private Integer amount;
    private Integer accountNumber;

    public DepositDto() {
    }

    public DepositDto(String accountType, Integer amount, Integer accountNumber) {
        this.accountType = accountType;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "DepositDto{" + "accountType=" + accountType + ", amount=" + amount + ", accountNumber=" + accountNumber + '}';
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

   

    public String getAccountType() {
        return accountType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    
    
    
    
}
