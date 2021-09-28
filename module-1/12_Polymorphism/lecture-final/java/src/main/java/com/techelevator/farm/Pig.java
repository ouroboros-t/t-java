package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal {

    public Pig() {
        super("Pig", "oink!", new BigDecimal("500.0"));
    }

    @Override
    public String getIndefiniteArticleForSound() {
        return "an";
    }
}
