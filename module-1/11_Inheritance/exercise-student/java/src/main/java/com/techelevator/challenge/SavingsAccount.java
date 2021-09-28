package com.techelevator.challenge;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolderName, String accountNumber){
        super(accountHolderName,accountNumber);
    }
    public SavingsAccount(String accountHolderName, String accountNumber, String balance) {
        super(accountHolderName,accountNumber,balance);

    }


    @Override
    public BigDecimal withdrawal(BigDecimal amountToWithdraw) {
        int result = 0;
        result = getBalance().subtract(amountToWithdraw).compareTo(BigDecimal.valueOf(20));
        if(result == 1) {
            super.withdrawal(amountToWithdraw);
            result = getBalance().compareTo(BigDecimal.valueOf(150));
            if(result == -1) {
                super.withdrawal(BigDecimal.valueOf(20));
            }

        }
        return getBalance();
    }








}
