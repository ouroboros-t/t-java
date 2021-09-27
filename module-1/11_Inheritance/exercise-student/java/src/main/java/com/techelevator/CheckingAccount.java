package com.techelevator;

public class CheckingAccount extends BankAccount {
    //CONSTRUCTORS MUST MATCH THE SUPERCLASS

    public CheckingAccount(String accountHolderName, String accountNumber){
        super(accountHolderName,accountNumber);
    }
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName,accountNumber,balance);

    }
    //METHODS

    //OVERRIDING WITHDRAW METHOD FROM BANKACCOUNT CLASS!!!
    //as long as balance is more than -100, any withdrawal is permitted,
    //so if balance - withdraw > -100, any is allowed,
    //but if balance - withdraw <= -100, it is not allowed
    //we flip the carrots because we're dealing with negatives, -3 is more than -5, etc..
    //use @Override keyword as saftey check to ensure we're overriding the correct method..

    @Override
    public int withdraw(int amountToWithdraw) {
        if(getBalance() - amountToWithdraw > (-100)){
            super.withdraw(amountToWithdraw);
            if(getBalance() < 0) {
                super.withdraw(10);
            }
            //once it's true, run the original method from superclass..
            //DRY...
        }
        return getBalance();
    }






}
