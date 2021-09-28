package com.techelevator.farm;

//Tractor is NOT a FarmAnimal
//Tractor is-a Singable class

import java.math.BigDecimal;

public class Tractor implements Singable, Sellable {
    //in order for Tractor to properly implement, it HAS to have the same methods that the interface calls.
    private String name;
    private String sound;
    private BigDecimal price;

    public Tractor () {
        this.name = "Tractor";
        this.sound = "vroom!";
    }
    public Tractor (String price){
        this.price = new BigDecimal(price);
    }

    public String getName(){
        return this.name;
    }
    public String getSound(){
        return this.sound;
    }

    public String getIndefiniteArticleForSound() {
        return "a";
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

}
