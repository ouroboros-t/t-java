package com.techelevator;

public class BankAccount {
    //PROPERTIES
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    //CONSTRUCTOR(S)
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //GETTERS AND SETTERS

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }


    //METHODS
    public int deposit(int amountToDeposit) {
        balance += amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance-= amountToWithdraw;
        return balance;
    }



}
