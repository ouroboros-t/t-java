package com.techelevator.farm;

public class Cat extends  FarmAnimal{
    public Cat(){super("Cat", "meow!"); }

    @Override
    public void eat() {
        System.out.println("The cat is eating kibble!");
    }


//this won't compile because FarmAnimal getSound is final
    //final methods CANNOT be overridden.
//    @Override
//    public String getSound(){
//        return "meow!";
//    }


}
