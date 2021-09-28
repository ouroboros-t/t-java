package com.techelevator.farm;

public class Pig extends FarmAnimal{
    public Pig() { super("Pig", "oink!", "4000"); }
    @Override
    public String getIndefiniteArticleForSound() {
        return "an";
    }

}

