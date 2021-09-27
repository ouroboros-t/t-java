package com.techelevator;

public class SavingsAccount extends BankAccount {
    //PROPERTIES
    public SavingsAccount(String accountHolderName, String accountNumber){
        super(accountHolderName,accountNumber);
    }
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName,accountNumber,balance);

    }
    //METHODS
    //only runs if balance - amounttowithdraw is greater than or equal to 0
    //furthermore, if balance is less than 150.00, then take 20.00 out..
    @Override
    public int withdraw(int amountToWithdraw) {
        if(getBalance() - amountToWithdraw >= 20){
            super.withdraw(amountToWithdraw);
            if(getBalance() < 150) {
                super.withdraw(2);
            }
            //once it's true, run the original method from superclass..
            //DRY...
        }
        return getBalance();
    }

}
