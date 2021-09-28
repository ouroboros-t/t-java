package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable {

    private BigDecimal price;

    public Egg() {
        this.price = new BigDecimal("0.25");
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
