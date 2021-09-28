package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<Accountable>();

    public BankCustomer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[0]);
        //we don't want user to be able to manipulate the Collection after it's been made
        //we've encapsulated accounts

    }

    //METHODS:
    public void addAccount(Accountable newAccount) {
       accounts.add(newAccount);
    }


    public boolean isVip(){
        int sum = 0;
        for(Accountable newAccount : accounts) {
            sum += newAccount.getBalance();
        }
        return sum >= 25000;
        }
}

