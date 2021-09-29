package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable {
    private BigDecimal price;

    public Pig() {
        super("Pig", "oink!");
        price = new BigDecimal("300.00");
    }
    @Override
    public void eat() {
        System.out.println("The cat is eating slop!");
    }

    public BigDecimal getPrice() {
        return price;
    }
}