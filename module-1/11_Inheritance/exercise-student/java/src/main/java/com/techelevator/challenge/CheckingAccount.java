package com.techelevator.challenge;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, String balance) {
        super(accountHolderName, accountNumber, balance);
    }


    //METHODS:
    @Override
    public BigDecimal withdrawal(BigDecimal amountToWithdraw){
        int result = 0;
        result = getBalance().subtract(amountToWithdraw).compareTo(BigDecimal.valueOf(-100));
        if(result == 1) {
            super.withdrawal(amountToWithdraw);
            result = getBalance().compareTo(BigDecimal.ZERO);
            if(result == -1) {
                super.withdrawal(BigDecimal.valueOf(10));
            }

        }
        return getBalance();
    }


}
