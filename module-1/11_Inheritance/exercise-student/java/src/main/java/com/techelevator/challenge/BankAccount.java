package com.techelevator.challenge;

import java.math.BigDecimal;

//challenge: Do everything again, except with BigDecimal in place of int..
public class BankAccount {
    //PROPERTIES


    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance;

    //CONSTRUCTOR(S)
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, String balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal(balance);
    }

    //GETTERS AND SETTERS:
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    //METHODS
    public BigDecimal deposit(BigDecimal amountToDeposit) {
        balance =  balance.add(amountToDeposit);
        return balance;
    }
    public BigDecimal withdrawal(BigDecimal amountToWithdraw){
        balance = balance.subtract(amountToWithdraw);
        return balance;
    }

}
